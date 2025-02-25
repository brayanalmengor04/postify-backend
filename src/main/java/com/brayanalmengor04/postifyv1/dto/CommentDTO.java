package com.brayanalmengor04.postifyv1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    private Long id;
    private String content;
    private int likes;
    private Long userId;
}
