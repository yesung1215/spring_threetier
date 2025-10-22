package com.app.threetier.service;

import com.app.threetier.domain.dto.MemberResponseDTO;
import com.app.threetier.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    @Test
    public void registerTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test789@gmail.com");
        memberVO.setMemberName("이순신");
        memberVO.setMemberPassword("1234");
        memberService.register(memberVO);
    }

    @Test
    public void loginTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("spring12345@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("배승일");
        MemberResponseDTO foundMember = memberService.login(memberVO);
        log.info("foundMember:{}",foundMember);
    }

    @Test
    public void updateTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setId(43L);
        memberVO.setMemberEmail("spring12345@gmail.com");
        memberVO.setMemberName("배승원");
        memberVO.setMemberPassword("4567");
        memberService.modify(memberVO);
    }

    @Test
    public void withdrawTest(){
        if(memberService.withDraw(43L)){
            log.info("withdraw success");
        }else{
            log.info("withdraw failure");
        }
    }

}
