package com.app.threetier.api;

import com.app.threetier.domain.dto.ApiResponseDTO;
import com.app.threetier.domain.dto.MemberResponseDTO;
import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/members/*")
@RequiredArgsConstructor
public class MemberAPI {

    private final MemberService memberService;

    @Operation(summary = "이메일 중복 확인", description = "이메일을 중복 확인해서 결과를 알려주는 API")
    @ApiResponse(responseCode = "200", description = "이메일 중복 여부 확인")
    @GetMapping("exist-email")
    public boolean existMemberEmail(@RequestBody String memberEmail) {
        return memberService.existMemberEmail(memberEmail);
    }

    @Operation(summary = "회원 가입", description = "회원가입을 할 수 있는 API")
    @ApiResponse(responseCode = "201", description = "회원가입 성공")
    @PostMapping("register")
    public ResponseEntity<ApiResponseDTO> register(@RequestBody MemberVO memberVO) {
        memberService.register(memberVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseDTO.of("회원 가입 완료"));
    }

    @Operation(summary = "로그인", description = "로그인을 할 수 있는 API")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "로그인 성공"),
            @ApiResponse(responseCode = "401", description = "인증 실패")
    })
    @PostMapping("login")
    public ResponseEntity<ApiResponseDTO> login(@RequestBody MemberVO memberVO) {
        MemberResponseDTO currentMember = memberService.login(memberVO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("로그인 성공", currentMember));
    }

    @Operation(summary = "회원 정보 수정", description = "회원의 정보를 수정할 수 있는 API")
    @ApiResponse(responseCode = "200", description = "회원 정보 수정 성공")
    @PutMapping("modify")
    public ResponseEntity<ApiResponseDTO> modifyMember(@RequestBody MemberVO memberVO) {
        MemberResponseDTO modifiedMember = memberService.modify(memberVO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("회원 정보 수정 완료", modifiedMember));
    }

    @Operation(summary = "회원 탈퇴", description = "회원의 정보를 삭제할 수 있는 API")
    @ApiResponse(responseCode = "204", description = "회원 탈퇴 성공")
    @DeleteMapping("withdraw")
    public boolean withdraw(@RequestBody Long id) {
        return memberService.withDraw(id);
    }

}
