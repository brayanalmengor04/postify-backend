package com.brayanalmengor04.postifyv1.service;

import com.brayanalmengor04.postifyv1.dto.CommentDTO;
import com.brayanalmengor04.postifyv1.entity.Comment;

import java.util.List;

public interface ICommentService {
    public List<Comment> getAllComments();
    public Comment addComment(CommentDTO commentDTO);

}
