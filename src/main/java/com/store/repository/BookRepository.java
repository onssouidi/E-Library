package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.models.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer > {
//    @Bean
}
