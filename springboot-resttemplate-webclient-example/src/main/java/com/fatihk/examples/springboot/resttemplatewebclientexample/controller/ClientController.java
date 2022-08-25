package com.fatihk.examples.springboot.resttemplatewebclientexample.controller;

import com.fatihk.examples.springboot.resttemplatewebclientexample.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/bookclient")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final RestTemplate restTemplate;

    private final String requestUrl = "http://localhost:8080/books";

    @GetMapping("/blocking")
    public ResponseEntity<List<Book>> getBooksBlocking(){
        log.info("getBooksBlocking starts");
        final String uri = requestUrl;

        RestTemplate restTemplate = new RestTemplate();
        //this call blocks the current thread
        ResponseEntity<List<Book>> response = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Book>>(){});

        List<Book> books = response.getBody();
        books.forEach(book -> log.info(book.toString()));
        log.info("getBooksBlocking ends");
        return ResponseEntity.ok(books);
    }

    @GetMapping("/nonblocking")
    public ResponseEntity<Flux<Book>> getBooksNonBlocking(){
        log.info("getBooksNonBlocking starts");
        Flux<Book> bookFlux = WebClient.create()
                .get()
                .uri(requestUrl)
                .retrieve()
                .bodyToFlux(Book.class);

        bookFlux.subscribe(book -> log.info(book.toString()));
        log.info("getBooksNonBlocking ends");
        return ResponseEntity.ok(bookFlux);
    }

}
