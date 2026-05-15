package com.prototipo.facebook.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototipo.facebook.DTO.Requests.AddPostRequest;
import com.prototipo.facebook.DTO.Responses.ApiResponse;
import com.prototipo.facebook.DTO.Responses.PostResponse;
import com.prototipo.facebook.Services.PostService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService service;

    public PostController(PostService service){
        this.service = service;
    }
    
    @PostMapping("/posting")
    public ApiResponse<AddPostRequest> posting(@RequestBody AddPostRequest post) {
        try{
            service.addPost(post);
            return new ApiResponse<AddPostRequest>(true, post, "Ejecucion satisfactoria");
        }catch(RuntimeException e){
            return new ApiResponse<>(false,null,e.getMessage());
        }
    }

    @GetMapping
    public ApiResponse<List<PostResponse>> getPosts() {
        try{
            List<PostResponse> posts = service.getPosts();
            return new ApiResponse<List<PostResponse>>(true, posts, "Posts obtenidos");
        }catch(RuntimeException e){
            return new ApiResponse<>(false, null, e.getMessage());
        }
    }

}
