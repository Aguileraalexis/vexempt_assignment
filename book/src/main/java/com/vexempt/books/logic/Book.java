package com.vexempt.books.logic;

import java.util.HashMap;
import java.util.List;

import com.vexempt.books.model.Quote;
import com.vexempt.books.utils.BinaryTree;

public class Book {
	
	private BinaryTree<Quote> bids = new BinaryTree<Quote>(new QuoteComparator(), null);
	private BinaryTree<Quote> offers = new BinaryTree<Quote>(new QuoteComparator(), null);
	private static final byte TUPLE_LENGTH = 5;
	private HashMap<String, Quote> map = new HashMap<String, Quote>();
	
	public void processQuery(String queryStr) {

		//validating tuple structure
		if (queryStr == null || queryStr.trim().isEmpty())
			throw new IllegalArgumentException("Empty Quote");
		
		String[] values = queryStr.split("/");
		if (values.length != TUPLE_LENGTH)
			throw new IllegalArgumentException("Insufficient Tuple Values");

		for (String value : values)
			if (value.trim().isEmpty())
				throw new IllegalArgumentException("All the tuple values are mandatory");
		
		String quoteId = values[0];
		String quoteType = values[1].length() > 0 ? values[1].substring(0, 1) : " ";
		String operatorType = values[2].length() > 0 ? values[2].substring(0, 1) : " ";
		Double price = Double.valueOf(values[3]);
		Double volume = Double.valueOf(values[4]);

		if (!"BO".contains(quoteType))
			throw new IllegalArgumentException("Quote Type is incorrect, expected one of B-O");
		
		if (!"NUD".contains(operatorType))
			throw new IllegalArgumentException("Operation Type is incorrect, expected one of N-U-D");
		
		//procesing command
		Quote quote = new Quote(quoteId, quoteType, price, volume);
		if (operatorType.equals("N")) {
			map.put(quoteId, quote);
			if (quoteType.equals("B")) bids.insert(quote);
			else offers.insert(quote);
		} else if (operatorType.equals("U")) {
			Quote updateQuote = map.get(quoteId);
			if (updateQuote != null) {
				updateQuote.setPrice(quote.getPrice());
				updateQuote.setVolume(quote.getVolume());
			}
		} else if (operatorType.equals("D")) {
			map.remove(quoteId);
			if (quoteType.equals("B")) bids.delete(quote);
			else offers.delete(quote);
		}

	}

	public String dump() {
		List<Quote> orderedBids = bids.getOrdered();
		List<Quote> orderedOffers = offers.getOrdered();

		StringBuilder builder = new StringBuilder();
		builder.append("OFFER\n");
		for (Quote quote : orderedOffers)
			builder.append(quote.pack() + "\n");
		
		builder.append("\nBIDS\n");
		for (Quote quote : orderedBids)
			builder.append(quote.pack() + "\n");
		
		return builder.toString();
	}

}
