package com.app.threetier.service;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.mapper.PostMapper;
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
    public void write(PostVO postVO) {
        postDAO.insert(postVO);
    }

//    게시글 목록
    @Override
    public List<PostDTO> selectAll() {
        return postDAO.selectAll();
    }

    @Override
    public Optional<PostDTO> select(Long id) {
        postDAO.updateReadCount(id);
        return postDAO.select(id);
    }

}
