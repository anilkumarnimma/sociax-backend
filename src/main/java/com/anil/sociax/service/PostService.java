package com.anil.sociax.service;

import com.anil.sociax.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final List<Post> posts = new ArrayList<>();
    private int counter = 1;

    public Post addPost(Post post) {
        post.setId(counter++);
        if (post.getCategory() == null || post.getCategory().isBlank()) {
            post.setCategory("HELP");
        }
        posts.add(post);
        return post;
    }

    public List<Post> getAll() {
        return posts;
    }

    public List<Post> getByCategory(String category) {
        List<Post> result = new ArrayList<>();
        for (Post p : posts) {
            if (p.getCategory() != null && p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }
}
