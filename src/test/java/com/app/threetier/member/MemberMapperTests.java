package com.app.threetier.member;

import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void registerTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("spring123@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("김철수");
        memberMapper.insert(memberVO);
    }

    @Test
    public void existTest(){
        log.info("이메일 중복확인: {}", memberMapper.existMemberEmail("test456@gmial.com"));
    }

    @Test
    public void selectTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("spring12345@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("김철수");
//        Optional<MemberVO> foundMember = memberMapper.select(memberVO);
//        log.info("foundMember: {}", foundMember);
    }

}
