package com.vexempt.books.model;

public class Quote {
	
	private String quoteId;
	private String quoteType;
	private double price;
	private double volume;

	public Quote(String quoteId, String quoteType, double price, double volume) {

		// saving data
		this.quoteId = quoteId;
		this.quoteType = quoteType;
		this.price = price;
		this.volume = volume;
		
	}
	
	@Override
	public boolean equals(Object o) {
	    if (o == this)
	        return true;
	    if (!(o instanceof Quote))
	        return false;
	    Quote other = (Quote) o;
		
		return this.quoteId.equals(other.getQuoteId());
	}

	public String getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(String quoteId) {
		this.quoteId = quoteId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Object pack() {
		return this.quoteId + "/" + this.getPrice() + "/" + this.getVolume();
	}

	public String getQuoteType() {
		return quoteType;
	}

	public void setQuoteType(String quoteType) {
		this.quoteType = quoteType;
	}
	
}
