package com.brayanalmengor04.postifyv1.service;

import com.brayanalmengor04.postifyv1.dto.CommentDTO;
import com.brayanalmengor04.postifyv1.entity.Comment;
import com.brayanalmengor04.postifyv1.entity.User;
import com.brayanalmengor04.postifyv1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<Comment> getAllComments() {
        return this.commentRepository.findAll();
    }

    @Override
    public Comment addComment(CommentDTO commentDTO) {
        User user = userService.getUserById(commentDTO.getUserId());
        if (user == null) {
            throw new RuntimeException("User not found with ID: " + commentDTO.getUserId());
        }
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setLikes(commentDTO.getLikes());
        comment.setUser(user);
        
        return commentRepository.save(comment);

    }

    @Override
    public Comment getCommentById(Long commentId) {
        return this.commentRepository.findById(commentId).orElse(null);
    }


    @Override
    public Comment updateComment(Long commentId, String newContent, Long userId) {
        Comment comment = this.commentRepository.findById(commentId).orElse(null);

        User user = userService.getUserById(userId);
        if(!comment.getUser().getId().equals(userId) &&
                !user.getRole().getRoleName().equals("Administrador")) {
            throw new RuntimeException("User not found with ID: " + comment.getUser().getId());
        }

        comment.setContent(newContent);
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        this.commentRepository.deleteById(commentId);

    }

}
