package com.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.models.Author;

public interface AuthRepo extends JpaRepository <Author,Long> {

}
  