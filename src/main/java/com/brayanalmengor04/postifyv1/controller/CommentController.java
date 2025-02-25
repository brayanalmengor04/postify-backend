package com.brayanalmengor04.postifyv1.controller;

import com.brayanalmengor04.postifyv1.dto.CommentDTO;
import com.brayanalmengor04.postifyv1.entity.Comment;
import com.brayanalmengor04.postifyv1.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("postify-app")
@CrossOrigin(value = "http://localhost:5173") // Permitir acceso desde el frontend
public class CommentController {

    @Autowired
    private ICommentService commentService;
    
    @GetMapping("comment")
    public ResponseEntity<List<Comment>> getComments() {
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @PostMapping("comment-add")
    public ResponseEntity<Comment> addComment(@RequestBody CommentDTO commentDTO) {
        Comment comment = commentService.addComment(commentDTO);
        return ResponseEntity.ok(comment);
    }
}
