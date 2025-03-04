package com.brayanalmengor04.postifyv1.repository;

import com.brayanalmengor04.postifyv1.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByAuthorId(Long userId);
    List<Reply> findByCommentId(Long commentId);
}
