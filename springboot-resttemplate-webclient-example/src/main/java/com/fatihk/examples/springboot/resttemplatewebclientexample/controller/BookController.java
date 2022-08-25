package com.fatihk.examples.springboot.resttemplatewebclientexample.controller;

import com.fatihk.examples.springboot.resttemplatewebclientexample.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    @PostConstruct
    private void init(){
        books.add(new Book("1", "Martin Eden", "Jack London", LocalDate.of(1903, 3, 17)));
        books.add(new Book("2", "Kürk Mantolu Madonna", "Sabahattin Ali", LocalDate.of(1940, 4, 17)));
        books.add(new Book("3", "Puslu Kıtalar Atlası", "İhsan Oktay Anar", LocalDate.of(1998, 3, 11)));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() throws InterruptedException {
        Thread.sleep(10 * 1000); // Just to simulate a slow service
        return ResponseEntity.ok(books);
    }

}
