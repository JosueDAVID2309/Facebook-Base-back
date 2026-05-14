package com.prototipo.facebook.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.facebook.Models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
