package com.app.threetier.service;


import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;

import java.util.List;
import java.util.Optional;

public interface PostService {
    // 이름: 서비스의 직관적인 이름

//    게시글 작성
    public Long write(PostVO postVO);

//    게시글 목록 selectAll -< getPosts
    public List<PostDTO> selectAll();

//    게시글 상세 조회 select -> getPost
    public PostDTO select(Long id);

//    게시글 상세 조회시 조회수 + 1
//    public void postReadCount(Long id);

//    게시글 수정 update -> modify
    public void update(PostVO postVO);

//    게시글 삭제 delete -> remove
    public void delete(Long id);


}
