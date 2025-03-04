package com.brayanalmengor04.postifyv1.service;

import com.brayanalmengor04.postifyv1.dto.ReplyDTO;
import com.brayanalmengor04.postifyv1.entity.Comment;
import com.brayanalmengor04.postifyv1.entity.Reply;
import com.brayanalmengor04.postifyv1.entity.User;
import com.brayanalmengor04.postifyv1.repository.CommentRepository;
import com.brayanalmengor04.postifyv1.repository.ReplyRepository;
import com.brayanalmengor04.postifyv1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyService implements IReplyService {

    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;


    public ReplyService(ReplyRepository replyRepository,
                        UserRepository userRepository, CommentRepository commentRepository) {
        this.replyRepository = replyRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Reply> getAllRepliesByUserId(Long userId) {
        return this.replyRepository.findByAuthorId(userId);
    }

    @Override
    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

    @Override
    public Reply findById(Long id) {
        return replyRepository.findById(id).orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));
    }
    @Override
    public Reply save(ReplyDTO replyDTO) {
        // Obtengo los id y los comparo con el DTO
        Optional<User> user = userRepository.findById(replyDTO.getUserId());
        Optional<Comment> comment = commentRepository.findById(replyDTO.getCommentId());

        if(user.isEmpty() || comment.isEmpty()) {
            throw new RuntimeException("User or comment not found");
        }

        Reply reply = new Reply();
        reply.setAuthor(user.get());
        reply.setContent(replyDTO.getContent());
        reply.setComment(comment.get());

        return replyRepository.save(reply);

    }
}
