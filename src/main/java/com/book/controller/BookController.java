package com.book.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.book.entity.Book;
import com.book.serviceimpl.BookServiceImpl;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
    private BookServiceImpl bookService;

    // Get all available books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Get book detail by bookId
    
     @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
    	 Book book = bookService.getBookById(bookId);
         return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
     }    

    // Purchase a book 
    @PutMapping("/{bookId}/purchase")
    public ResponseEntity<String> purchaseBook(@PathVariable Long bookId) {
        boolean isPurchased = bookService.purchaseBook(bookId);

        if (isPurchased) {
            return ResponseEntity.ok("Book purchased successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book is already sold or not found.");
        }
    }

}
