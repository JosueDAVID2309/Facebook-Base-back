package com.prototipo.facebook.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.facebook.Models.Comment;

public interface CommetRepository extends JpaRepository<Comment, Long>{
    
}
