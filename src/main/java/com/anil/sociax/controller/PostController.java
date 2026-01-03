package com.anil.sociax.controller;

import com.anil.sociax.model.Post;
import com.anil.sociax.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    // Create post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return service.createPost(post);
    }

    // Get all posts (or by category)
    @GetMapping
    public List<Post> getAllPosts(
            @RequestParam(required = false) String category) {

        if (category != null) {
            return service.getByCategory(category);
        }
        return service.getAllPosts();
    }

    // Get single post by ID
    @GetMapping("/{id}")
    public Object getPostById(@PathVariable int id) {
        Post post = service.getById(id);
        if (post == null) {
            return Map.of("error", "Post not found");
        }
        return post;
    }

    // Delete post by ID
    @DeleteMapping("/{id}")
    public Map<String, String> deletePost(@PathVariable int id) {
        boolean removed = service.deleteById(id);
        if (!removed) {
            return Map.of("error", "Post not found");
        }
        return Map.of("message", "Post deleted");
    }
}
