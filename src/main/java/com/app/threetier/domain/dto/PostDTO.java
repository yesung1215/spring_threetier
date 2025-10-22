package com.app.threetier.domain.dto;

import lombok.Data;

@Data
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long postReadCount;
    private Long memberId;
    private String memberName;
    private String memberEmail;
}
