package com.book.service;


import java.util.List;

import com.book.entity.Book;

public interface BookService {
	public List<Book> getAllBooks();
	public Book getBookById(Long id);
	boolean purchaseBook(Long bookId);
	
}
