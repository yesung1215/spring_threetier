package com.app.threetier.api;

import com.app.threetier.domain.dto.ApiResponseDTO;
import com.app.threetier.domain.dto.MemberResponseDTO;
import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/members/*")
@RequiredArgsConstructor
public class MemberAPI {

    private final MemberService memberService;

    @GetMapping("exist-email")
    public boolean existMemberEmail(String memberEmail) {
        return memberService.existMemberEmail(memberEmail);
    }

    @PostMapping("register")
    public ResponseEntity<ApiResponseDTO> register(MemberVO memberVO) {
        memberService.register(memberVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseDTO.of("회원 가입 완료"));
    }

    @PostMapping("login")
    public ResponseEntity<ApiResponseDTO> login(MemberVO memberVO) {
        MemberResponseDTO currentMember = memberService.login(memberVO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("로그인 성공", currentMember));
    }

    @PutMapping("modify")
    public ResponseEntity<ApiResponseDTO> modifyMember(MemberVO memberVO) {
        MemberResponseDTO modifiedMember = memberService.modify(memberVO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("회원 정보 수정 완료", modifiedMember));
    }

    @DeleteMapping("withdraw")
    public boolean withdraw(Long id) {
        return memberService.withDraw(id);
    }

}
