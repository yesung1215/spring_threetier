package com.app.threetier.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "회원 정보")
public class MemberVO {

    @Schema(description = "회원 고유 번호", required = true, example = "3")
    private Long id;
    @Schema(description = "회원 이메일", required = true, example = "test123@gmail.com")
    private String memberEmail;
    @Schema(description = "회원 비밀번호", required = true, example = "example123!23!@#")
    private String memberPassword;
    @Schema(description = "회원 이름", example = "홍길동")
    private String memberName;
}
