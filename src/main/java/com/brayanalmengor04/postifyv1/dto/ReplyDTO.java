package com.brayanalmengor04.postifyv1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDTO {
    private Long id;
    private String content;
    private Long userId;
    private Long commentId;

}
