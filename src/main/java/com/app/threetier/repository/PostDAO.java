package com.app.threetier.repository;


import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

//    게시글 작성
    public void insert(PostVO postVO){
        postMapper.insert(postVO);
    }

//    게시글 목록
    public List<PostDTO> selectAll(){
        return postMapper.selectAll();
    }

//    게시글 조회
    public Optional<PostDTO> select(Long id){
        return postMapper.select(id);
    }

//    조회수 +1(상세보기)
    public void updateReadCount(Long id){
        postMapper.updateReadCount(id);
    }



}
