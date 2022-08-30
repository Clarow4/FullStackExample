package com.example.nateratechinterview.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.nateratechinterview.entities.Articles;

@Repository
public interface ArticleRepository extends CrudRepository<Articles, Long> {

}