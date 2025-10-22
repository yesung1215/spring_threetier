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
        postDAO.insert(postVO);
    }

    @Test
    public void selectAll(){
        PostDTO postDTO = new PostDTO();
        postDAO.selectAll();
    }

}
