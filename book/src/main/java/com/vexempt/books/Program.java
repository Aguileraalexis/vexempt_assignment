package com.vexempt.books;

import com.vexempt.books.logic.Book;

public class Program {

	public static void main(String[] args) {
		
		String[] data = new String[] {
			"Q1/O/N/1.31/1000000" 
			,"Q2/B/N/1.21/1000000" 
			,"Q3/B/N/1.22/1000000" 
			,"Q4/B/N/1.20/1000000" 
			,"Q5/B/N/1.20/1000000" 
			,"Q6/O/N/1.32/1000000" 
			,"Q7/O/N/1.33/200000" 
			,"Q5/B/U/1.20/500000" 
			,"Q7/O/U/1.33/100000" 
			,"Q7/O/D/0/0"
		};
		
		Book book = new Book();
		for (String quote : data) {
			book.processQuery(quote);
		}
		
		System.out.print(book.dump());
		
	}

}
