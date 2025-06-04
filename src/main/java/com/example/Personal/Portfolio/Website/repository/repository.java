package com.example.Personal.Portfolio.Website.repository;

import com.example.Personal.Portfolio.Website.Model.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repository extends JpaRepository<Blogs, Integer> {
}
