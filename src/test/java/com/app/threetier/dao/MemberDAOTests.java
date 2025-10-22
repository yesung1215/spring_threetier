package com.app.threetier.dao;

import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.repository.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberDAOTests {
    @Autowired
    private MemberDAO memberDao;

    @Test
    public void test(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("spring345@gmail.com");
        memberVO.setMemberPassword("123456");
        memberVO.setMemberName("김영희");
        memberDao.save(memberVO);
    }

    @Test
    public void findMemberTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("spring123@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("김철수");
//        log.info("memberVO: {}", memberDao.findMemberById(memberVO.getId()));
    }

}
