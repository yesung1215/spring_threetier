package com.app.threetier.service;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Transactional
// 트랜잭션 작업 중 오류가 발생했을 때 특정 커밋을 방지하고, 롤백시키는 어노테이션이다.

// 회원 가입 서비스는 어떤 기능들이 있는가?
// 1. 이메일 인증
// 2. 핸드폰 인증
// 3. 이메일 중복확인
// 4. MemberVO를 받아서 회원가입
// 5. 비밀번호 암호화
// 6. DB에 memberVO 등록
// 7. 토큰 생성
// 8. 토큰 반환

@Service
@Transactional(rollbackFor = Exception.class) @RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Override
    public void register(MemberVO memberVO) {
        memberDAO.save(memberVO);
    }
}
