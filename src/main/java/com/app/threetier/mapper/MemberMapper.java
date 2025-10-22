package com.app.threetier.mapper;

import com.app.threetier.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {

//    이메일 중복 확인
    public boolean existMemberEmail(String memberEmail);

//    회원가입
    public void insert(MemberVO memberVO);

//    회원 조회
    public Optional<MemberVO> select(Long id);

//    이메일로 Id 조회
    public Long selectByMemberEmail(String memberEmail);

//    회원 정보 수정
    public void update(MemberVO memberVO);

//    회원 탈퇴
    public void delete(Long id);

}
