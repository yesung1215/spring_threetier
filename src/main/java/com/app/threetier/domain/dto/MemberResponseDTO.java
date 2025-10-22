package com.app.threetier.domain.dto;

import com.app.threetier.domain.vo.MemberVO;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class MemberResponseDTO {
    private Long id;
    private String memberEmail;
    private String memberName;

    public MemberResponseDTO(MemberVO memberVO) {
        this.id = memberVO.getId();
        this.memberEmail = memberVO.getMemberEmail();
        this.memberName = memberVO.getMemberName();
    }

}