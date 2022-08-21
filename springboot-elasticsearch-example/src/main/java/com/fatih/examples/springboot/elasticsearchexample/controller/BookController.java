package com.fatih.examples.springboot.elasticsearchexample.controller;

import com.fatih.examples.springboot.elasticsearchexample.model.Book;
import com.fatih.examples.springboot.elasticsearchexample.repository.BookRepository;
import com.fatih.examples.springboot.elasticsearchexample.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostConstruct
    public void init(){
        Book book = new Book("1", "Jack London", "Martin Eden", LocalDate.of(1924, 1, 17));
        bookService.delete(book.getId());
        bookService.save(book);

        book = new Book("2", "Mustafa Kemal Atatürk", "Nutuk", LocalDate.of(1927, 2, 19));
        bookService.delete(book.getId());
        bookService.save(book);

        book = new Book("3", "Jack London", "The Son of the Wolf", LocalDate.of(1900, 11, 3));
        bookService.delete(book.getId());
        bookService.save(book);

    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping("/search/{searchTerm}")
    public ResponseEntity<List<Book>> findBooks(@PathVariable String searchTerm, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(bookService.findBooks(searchTerm,  PageRequest.of(page, size)));
    }

}
