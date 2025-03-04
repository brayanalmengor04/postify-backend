package com.brayanalmengor04.postifyv1.controller;

import com.brayanalmengor04.postifyv1.dto.ReplyDTO;
import com.brayanalmengor04.postifyv1.entity.Reply;
import com.brayanalmengor04.postifyv1.service.ReplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("postify-app")
@CrossOrigin(value = "http://localhost:5173")
public class ReplyController {

    private final ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @PostMapping("/reply/user")
    public ResponseEntity<Reply> createReply(@RequestBody ReplyDTO replyDTO) {
        Reply savedReply = replyService.save(replyDTO);
        return ResponseEntity.ok(savedReply);
    }

    @GetMapping("/reply/user/{userId}")
    public ResponseEntity<List<Reply>> getRepliesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(replyService.getAllRepliesByUserId(userId));
    }
}
