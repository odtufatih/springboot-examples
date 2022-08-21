package com.fatih.examples.springboot.elasticsearchexample.service;

import com.fatih.examples.springboot.elasticsearchexample.model.Book;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BookService {

    public List<Book> getAllBooks();

    public Book save(Book book);

    public void delete(String bookId);

    public Book getBookById(String bookId);

    List<Book> findBooks(String searchTerm, PageRequest pageRequest);
}
