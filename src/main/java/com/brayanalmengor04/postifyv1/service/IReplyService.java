package com.brayanalmengor04.postifyv1.service;

import com.brayanalmengor04.postifyv1.dto.ReplyDTO;
import com.brayanalmengor04.postifyv1.entity.Reply;

import java.util.List;

public interface IReplyService {
    public Reply findById(Long id);
    public List<Reply> getAllRepliesByUserId(Long userId);
    public Reply save(ReplyDTO replyDTO);
}
