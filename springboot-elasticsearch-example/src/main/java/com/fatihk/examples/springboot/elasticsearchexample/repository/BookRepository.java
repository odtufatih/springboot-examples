package com.fatihk.examples.springboot.elasticsearchexample.repository;

import com.fatihk.examples.springboot.elasticsearchexample.model.Book;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, String> {

    List<Book> findByTitleLikeOrAuthorLike(String title, String author, PageRequest pageRequest);

}
