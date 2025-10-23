package com.app.threetier.service;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.exception.PostException;
import com.app.threetier.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor @Slf4j
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

//    게시글 작성
    @Override
    public Long write(PostVO postVO) {
        Long writedPostId = postDAO.insert(postVO);
        return writedPostId;
    }

//    게시글 목록
    @Override
    public List<PostDTO> selectAll() {
        return postDAO.selectAll();
    }

//   게시글 조회
    @Override
    public PostDTO select(Long id) {
        postDAO.updateReadCount(id);
        return postDAO.select(id).orElseThrow(() -> new PostException("해당 게시물 없음"));
    }

//    게시글 수정
    @Override
    public void update(PostVO postVO) {
        postDAO.update(postVO);
    }

//    게시글 삭제
    @Override
    public void delete(Long id) {
        postDAO.delete(id);
    }
}
