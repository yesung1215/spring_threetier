package com.app.threetier.repository;

import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// jpa
@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

//    이메일 중복
    public boolean existMemberEmail(String memberEmail) {
        memberMapper.existMemberEmail(memberEmail);
        return true;
    }

    //  회원 가입
    public void save(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

//    아이디로 회원 조회
    public Optional<MemberVO> findMemberById(Long id){
        return memberMapper.select(id);
    };

//    이메일로 아이디 조회
    public Long findMemberIdByMemberEmail(String memberEmail){
        return memberMapper.selectByMemberEmail(memberEmail);
    }

//    회원 정보 수정
    public void updateByMember(MemberVO memberVO){
        memberMapper.update(memberVO);
    }

//    회원 탈퇴
    public void deleteById(Long id){
        memberMapper.delete(id);
    }

}
