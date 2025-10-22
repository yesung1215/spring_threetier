package com.app.threetier.api;


import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class PostAPI {
    private final PostService postService;

    @PostMapping("write")
    public void wrtie(PostVO postVO){
        postService.write(postVO);
    }

    @PostMapping("list")
    public List<PostDTO> showList(){
        return postService.selectAll();
    }

}
