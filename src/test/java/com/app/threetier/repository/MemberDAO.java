package com.app.threetier.repository;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

// jpa
@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    //  회원 가입
    public void save(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

}
