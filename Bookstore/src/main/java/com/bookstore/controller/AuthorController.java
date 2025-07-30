package com.bookstore.controller;

import com.bookstore.models.Author;
import com.bookstore.repo.AuthRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthRepo authRepo;

    // GET all authors
    @GetMapping
    public List<Author> getAllAuthors() {
        return authRepo.findAll();
    }

    // GET author by ID
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Optional<Author> author = authRepo.findById(id);
        return author.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // POST create new author
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authRepo.save(author);
    }

    // PUT update existing author
    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
        return authRepo.findById(id).map(author -> {
            author.setAuthName(updatedAuthor.getAuthName());
            author.setBooks(updatedAuthor.getBooks());
            return ResponseEntity.ok(authRepo.save(author));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE author
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        if (authRepo.existsById(id)) {
            authRepo.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
