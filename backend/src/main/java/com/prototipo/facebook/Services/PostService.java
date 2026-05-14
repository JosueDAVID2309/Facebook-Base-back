package com.prototipo.facebook.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.prototipo.facebook.DTO.Requests.AddPostRequest;
import com.prototipo.facebook.DTO.Responses.PostResponse;
import com.prototipo.facebook.Mappers.PostMapper;
import com.prototipo.facebook.Models.Post;
import com.prototipo.facebook.Models.User;
import com.prototipo.facebook.Repositories.PostRepository;
import com.prototipo.facebook.Repositories.UserRepository;

@Service
public class PostService {
    private final PostRepository repo;
    private final PostMapper mapper;
    private final UserRepository userRepo;
    
    public PostService(PostRepository repo, PostMapper mapper, UserRepository userRepo){
        this.repo = repo;
        this.mapper = mapper;
        this.userRepo = userRepo;
    }

    public void addPost(AddPostRequest request){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String email = auth.getName();

        User author = userRepo.findByCorreo(email).orElseThrow();

        Post newPost = mapper.toEntity(request, author);
        repo.save(newPost);
    }

    public List<PostResponse> getPosts(){
        
        List<Post> posts = repo.findAll();
        List<PostResponse> postsresponse = new ArrayList<>();
        
        for(Post post : posts){
            postsresponse.add(mapper.toShow(post));
        }

        return postsresponse;
    }
}
