package com.anil.sociax.service;

import com.anil.sociax.model.Post;
import com.anil.sociax.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // CREATE
    public Post createPost(Post post) {
        post.setId(null); // ensure auto-generated id
        return postRepository.save(post);
    }

    // GET ALL
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // ✅ GET BY ID (THIS fixes your controller error)
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
    }

    // DELETE
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}