package com.anil.sociax.controller;

import com.anil.sociax.model.Post;
import com.anil.sociax.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    // Create a post
    @PostMapping
    public Post create(@RequestBody Post post) {  //sociax posts API
        return service.addPost(post);
    }

    // Get all posts (optional filter by category)
    @GetMapping
    public List<Post> getAll(@RequestParam(required = false) String category) {
        if (category == null || category.isBlank()) {
            return service.getAll();
        }
        return service.getByCategory(category);
    }
}
