package com.anil.sociax.controller;

import com.anil.sociax.model.Comment;
import com.anil.sociax.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "*")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // POST http://localhost:8080/posts/1/comments
    @PostMapping("/{postId}/comments")
    public Comment addComment(@PathVariable Long postId, @RequestBody Comment comment) {
        return commentService.addCommentToPost(postId, comment);
    }

    // GET http://localhost:8080/posts/1/comments
    @GetMapping("/{postId}/comments")
    public List<Comment> getCommentsForPost(@PathVariable Long postId) {
        return commentService.getCommentsForPost(postId);
    }

    // DELETE http://localhost:8080/posts/comments/5
    @DeleteMapping("/comments/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return "Deleted comment id: " + commentId;
    }
}