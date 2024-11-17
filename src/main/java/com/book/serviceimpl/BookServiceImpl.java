package com.book.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.entity.Book;
import com.book.repository.BookRepository;
import com.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
    private BookRepository bookRepository;

	//Fetching all books/records
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findByStatus("available");
	}

	// getting Book by Book id
	@Override
	public Book getBookById(Long id) {
		// TODO Auto-generated method stub
		return bookRepository.getById(id);
	}

	
	@Override
	public boolean purchaseBook(Long bookId) {
		// TODO Auto-generated method stub
		Book book = getBookById(bookId);
		
		if (book != null && "available".equals(book.getStatus())) {
            book.setStatus("sold");
            bookRepository.save(book);
            return true;
        }	        return false;
	
	}

}
