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

    // GET all (or filter by category)
    @GetMapping
    public List<Post> getAll(@RequestParam(required = false) String category) {
        if (category == null || category.isBlank()) {
            return service.getAll();
        }
        return service.getByCategory(category);
    }

    // GET by id
    @GetMapping("/{id}")
    public Object getPostById(@PathVariable int id) {
        Post post = service.getById(id);
        if (post == null) {
            return Map.of("error", "Post not found");
        }
        return post;
    }

    // CREATE
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return service.create(post);
    }

    // ✅ UPDATE (FULL UPDATE)
    @PutMapping("/{id}")
    public Object updatePost(@PathVariable int id, @RequestBody Post post) {
        Post updated = service.update(id, post);
        if (updated == null) {
            return Map.of("error", "Post not found");
        }
        return updated;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public Map<String, String> deletePost(@PathVariable int id) {
        boolean removed = service.deleteById(id);
        if (!removed) {
            return Map.of("error", "Post not found");
        }
        return Map.of("message", "Post deleted");
    }
}
