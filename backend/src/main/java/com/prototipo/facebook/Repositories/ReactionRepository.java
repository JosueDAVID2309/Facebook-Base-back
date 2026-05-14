package com.prototipo.facebook.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.facebook.Models.Reaction;

public interface ReactionRepository extends JpaRepository<Reaction, Long>{
    
}
