package com.app.threetier.dao;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.repository.PostDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class PostDAOTests {
    @Autowired
    private PostDAO postDAO;

    @Test
    public void insertPost(){
        PostVO postVO = new PostVO();
        postVO.setPostTitle("다오 제목 테스트1");
        postVO.setPostContent("다오 내용 테스트1");
        postVO.setMemberId(1L);
        Long postId = postDAO.insert(postVO);
        log.info("{}", postId);
    }

    @Test
    public void selectAll(){
        PostDTO postDTO = new PostDTO();
        log.info("{}", postDAO.selectAll());
    }

    @Test
    public void select(){
        PostDTO postDTO = new PostDTO();
        log.info("{}", postDAO.select(14L));
    }

    @Test
    public void updateReadCount(){
        PostDTO postDTO = new PostDTO();
        postDAO.updateReadCount(9L);
    }

    @Test
    public void update(){
        PostVO postVO = new PostVO();
        postVO.setId(10L);
        postVO.setPostTitle("다오 테스트");
        postVO.setPostContent(postVO.getPostContent());
        postDAO.update(postVO);
    }

    @Test
    public void delete(){
        postDAO.delete(10L);
    }

}
