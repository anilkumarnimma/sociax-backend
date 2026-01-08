package com.anil.sociax.service;

import com.anil.sociax.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final List<Post> posts = new ArrayList<>();
    private int nextId = 1;

    public PostService() {
        // sample data
        posts.add(new Post(nextId++, "Roommate needed near Journal Square",
                "Budget $900-1200. Move-in Feb.",
                "HOUSING", "Jersey City"));

        posts.add(new Post(nextId++, "Study group for Spring Boot",
                "Looking for 2-3 people to build projects together",
                "COMMUNITY", "Jersey City"));
    }

    public List<Post> getAll() {
        return posts;
    }

    public List<Post> getByCategory(String category) {
        if (category == null || category.isBlank()) return posts;

        List<Post> result = new ArrayList<>();
        for (Post p : posts) {
            if (p.getCategory() != null && p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }

    public Post getById(int id) {
        for (Post p : posts) {
            if (p.getId() != null && p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public Post create(Post post) {
        post.setId(nextId++);
        posts.add(post);
        return post;
    }

    // ✅ UPDATE
    public Post update(int id, Post updatedPost) {
        Post existing = getById(id);
        if (existing == null) return null;

        existing.setTitle(updatedPost.getTitle());
        existing.setContent(updatedPost.getContent());
        existing.setCategory(updatedPost.getCategory());
        existing.setCity(updatedPost.getCity());

        return existing;
    }

    public boolean deleteById(int id) {
        Post existing = getById(id);
        if (existing == null) return false;
        posts.remove(existing);
        return true;
    }
}
