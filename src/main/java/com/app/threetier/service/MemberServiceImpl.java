package com.app.threetier.service;

import com.app.threetier.domain.dto.MemberResponseDTO;
import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.exception.MemberException;
import com.app.threetier.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

// Transactional
// 트랜잭션 작업 중 오류가 발생했을 때 특정 커밋을 방지하고, 롤백시키는 어노테이션이다.

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor @Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean existMemberEmail(String memberEmail) {
        return memberDAO.existMemberEmail(memberEmail);
    }

    @Override
    public void register(MemberVO memberVO) {
        // 비밀번호 암호화
        memberVO.setMemberPassword(passwordEncoder.encode(memberVO.getMemberPassword()));
        memberDAO.save(memberVO);
    }

    @Override
    public MemberResponseDTO login(MemberVO memberVO) {
        if(!memberDAO.existMemberEmail(memberVO.getMemberEmail())) {
            throw new MemberException("이메일이 존재하지 않습니다.");
        }

        // 화면에서 받은 Email로 Id를 조회
        Long id = memberDAO.findMemberIdByMemberEmail(memberVO.getMemberEmail());
        MemberVO foundMember = memberDAO.findMemberById(id).orElseThrow(() -> new MemberException("유저를 찾을 수 없습니다"));

//        .matches(평문 비밀번호, DB에 인코딩된 비밀번호)
        if(!passwordEncoder.matches(memberVO.getMemberPassword(), foundMember.getMemberPassword())){
            throw new MemberException("비밀번호가 일치하지 않습니다");
        }

        MemberResponseDTO memberResponse = new MemberResponseDTO(foundMember);
        return memberResponse;
    }

//    회원 정보 수정
    @Override
    public MemberResponseDTO modify(MemberVO memberVO) {
        memberVO.setMemberPassword(passwordEncoder.encode(memberVO.getMemberPassword()));
        memberDAO.updateByMember(memberVO);
        MemberVO foundMember = memberDAO.findMemberById(memberVO.getId())
                .orElseThrow(() -> new MemberException("유저를 찾을 수 없습니다"));

        return new MemberResponseDTO(foundMember);

    }

//    회원 탈퇴
    @Override
    public boolean withDraw(Long id) {
//       모든 서비스들의 해당 유저 정보를 삭제 후
//        멤버 테이블에서 멤버를 삭제(소프트 델리트)
        boolean isWithdraw = false;
        try {
            memberDAO.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }




}










