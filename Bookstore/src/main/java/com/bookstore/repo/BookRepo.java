package com.bookstore.repo;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.models.Book;

public interface BookRepo extends JpaRepository<Book,Long>{
	 Page<Book> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
