package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import com.bookstore.models.Author;
import com.bookstore.models.Book;
import com.bookstore.repo.AuthRepo;
import com.bookstore.repo.BookRepo;

@RestController
@RequestMapping("/api/books")
public class BookController {
	 @Autowired private BookRepo bookRepo;
	    @Autowired private AuthRepo authorRepo;

	    @GetMapping
	    public Page<Book> getBooks(@RequestParam(required = false) String name,
	                               @RequestParam(defaultValue = "0") int page,
	                               @RequestParam(defaultValue = "10") int size,
	                               @RequestParam(defaultValue = "id,asc") String[] sort) {

	        Sort.Direction direction = sort[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
	        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));

	        if (name != null) {
	            return bookRepo.findByNameContainingIgnoreCase(name, pageable);
	        }

	        return bookRepo.findAll(pageable);
	    }

	    @PostMapping
	    public ResponseEntity<Book> createBook(@RequestBody Book book) {
	        if (book.getAuthor() != null && book.getAuthor().getAuthorId()!=null) {
	            Optional<Author> author = authorRepo.findById(book.getAuthor().getAuthorId());
	            author.ifPresent(book::setAuthor);
	        }
	        return ResponseEntity.ok(bookRepo.save(book));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Book> getById(@PathVariable Long id) {
	        return bookRepo.findById(id).map(ResponseEntity::ok)
	                       .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
	        return bookRepo.findById(id).map(existing -> {
	            existing.setName(book.getName());
	            existing.setAuthor(book.getAuthor());
	            return ResponseEntity.ok(bookRepo.save(existing));
	        }).orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public void deleteBook(@PathVariable Long id) {
	        bookRepo.deleteById(id);
	    }
	
}
