package com.fatihk.examples.springboot.elasticsearchexample.service.impl;

import com.fatihk.examples.springboot.elasticsearchexample.model.Book;
import com.fatihk.examples.springboot.elasticsearchexample.repository.BookRepository;
import com.fatihk.examples.springboot.elasticsearchexample.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Book save(Book book){
        return bookRepository.save(book);
    }

    @Override
    public void delete(String bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book getBookById(String bookId) {
        return bookRepository.findById(bookId).orElseThrow( () -> new RuntimeException("Book not found"));
    }

    @Override
    public List<Book> findBooks(String searchTerm, PageRequest pageRequest) {
        return bookRepository.findByTitleLikeOrAuthorLike(searchTerm, searchTerm, pageRequest);
    }

}
