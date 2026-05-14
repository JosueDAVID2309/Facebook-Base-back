package com.prototipo.facebook.Mappers;

import org.springframework.stereotype.Component;

import com.prototipo.facebook.DTO.Requests.AddPostRequest;
import com.prototipo.facebook.DTO.Requests.UpdatePostRequest;
import com.prototipo.facebook.DTO.Responses.PostResponse;
import com.prototipo.facebook.Models.Post;
import com.prototipo.facebook.Models.User;

@Component
public class PostMapper {
    
    public Post toEntity(AddPostRequest request, User author){
        Post post = new Post();
        post.setDescripcion(request.getDescripcion());
        post.setAuthor(author);
        post.setImageUrl(request.getImageUrl());
        return post;
    }

    public void updateEntity(Post post, UpdatePostRequest request) {
        post.setDescripcion(request.getDescripcion());
        post.setImageUrl(request.getImageurl());
    }

    public PostResponse toShow(Post post){
        PostResponse showpost = new PostResponse();
        showpost.setAuthor(post.getAuthor().getNombres());
        showpost.setImageURL(post.getImageUrl());
        showpost.setDescripcion(post.getDescripcion());
        showpost.setCountLikes(post.getLikes().size());
        showpost.setCountCommets(post.getComments().size());
        showpost.setCreatedAt(post.getCreatedAt());
        showpost.setUpdatedAt(post.getUpdatedAt());

        return showpost;

    }
}
