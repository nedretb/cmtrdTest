package com.example.cmtrdtest.repository;

import com.example.cmtrdtest.model.Hello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelloRepository extends JpaRepository<Hello, Long> {

    List<Hello> findByLang(String lang);

}
