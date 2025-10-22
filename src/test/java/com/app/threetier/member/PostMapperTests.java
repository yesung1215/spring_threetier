package com.app.threetier.member;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.mapper.PostMapper;
import com.app.threetier.repository.PostDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j

public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;

//    게시물 등록
    @Test
    public void insert() {
        PostVO postVO = new PostVO();
        postVO.setPostTitle("제목 테스트1");
        postVO.setPostContent("내용 테스트1");
        postVO.setMemberId(2L);
        postMapper.insert(postVO);
    }

    @Test
    public void selectAll(){
        PostDTO postDTO = new PostDTO();
        postMapper.selectAll();
    }

}
