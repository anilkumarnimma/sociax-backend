package com.anil.sociax.service;

import com.anil.sociax.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final List<Post> posts = new ArrayList<>();
    private int counter = 1;

    // Create a new post
    public Post createPost(Post post) {
        post.setId(counter++);
        posts.add(post);
        return post;
    }

    // Get all posts
    public List<Post> getAllPosts() {
        return posts;
    }

    // Get posts by category
    public List<Post> getByCategory(String category) {
        List<Post> result = new ArrayList<>();
        for (Post p : posts) {
            if (p.getCategory() != null &&
                    p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }

    // Get a post by ID
    public Post getById(int id) {
        for (Post p : posts) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Delete a post by ID
    public boolean deleteById(int id) {
        Post found = null;
        for (Post p : posts) {
            if (p.getId() == id) {
                found = p;
                break;
            }
        }
        if (found == null) {
            return false;
        }
        posts.remove(found);
        return true;
    }
}
