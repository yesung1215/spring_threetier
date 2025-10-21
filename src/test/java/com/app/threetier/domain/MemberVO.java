package com.app.threetier.domain;

import lombok.Data;

@Data
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
