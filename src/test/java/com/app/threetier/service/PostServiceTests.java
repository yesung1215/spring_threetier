package com.app.threetier.service;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostServiceTests {

    @Autowired
    private PostService postService;

    @Test
    public void insertPost() {
        PostVO postVO = new PostVO();
        postVO.setPostTitle("제목 서비스 테스트1");
        postVO.setPostContent("내용 서비스 테스트1");
        postVO.setMemberId(3L);
        postService.write(postVO);
    }

    @Test
    public void selectAll(){
        PostDTO postDTO = new PostDTO();
        postService.selectAll();
    }

    @Test
    public void select(){
        PostDTO postDTO = new PostDTO();
        postService.select(11L);
    }

    @Test
    public void update(){
        PostVO postVO = new PostVO();
        postVO.setId(14L);
        postVO.setPostTitle("서비스 테스트");
        postVO.setPostContent("수고요");
        postService.update(postVO);
    }

    @Test
    public void delete(){
        postService.delete(11L);
    }



}
