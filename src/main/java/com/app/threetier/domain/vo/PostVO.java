package com.app.threetier.domain.vo;

import lombok.Data;

@Data
public class PostVO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long postReadCount;
    private Long memberId;
}
