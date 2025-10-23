package com.app.threetier.mapper;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper

public interface PostMapper {
//    1. 게시판 등록
    public Long insert(PostVO postVO);

//    2. 게시글 목록(JOIN - 작성자 이름, 작성자 이메일)-->
    public List<PostDTO> selectAll();

//    3. 게시글 상세 조회(JOIN - 작성자 이름, 작성자 이메일)
    public Optional<PostDTO> select(Long id);

//    3-1. 조회수 늘리기
    public void updateReadCount(Long id);

//    4. 게시글 수정
    public void update(PostVO postVO);

//    5. 게시글 삭제
    public void delete(Long id);

}
