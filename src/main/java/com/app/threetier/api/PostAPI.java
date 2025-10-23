package com.app.threetier.api;


import com.app.threetier.domain.dto.ApiResponseDTO;
import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.repository.PostDAO;
import com.app.threetier.service.MemberService;
import com.app.threetier.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts/*")
@RequiredArgsConstructor
public class PostAPI {
    private final PostService postService;
    private final PostDAO postDAO;
    private final MemberService memberService;

    @PostMapping("write")
    public ResponseEntity<ApiResponseDTO<Object>> wrtie(@RequestBody PostVO postVO){
        Long writedId = postService.write(postVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseDTO.of("게시판 등록 완료", writedId));
    }

    @PostMapping("list")
    public List<PostDTO> showList(){
        return postService.selectAll();
    }

    @PostMapping("read-post/{id}")
    public PostDTO readPost(@PathVariable Long id){
        postDAO.updateReadCount(id);
        return postService.select(id);
    }

    @PutMapping("modify/{id}")
    public ResponseEntity<ApiResponseDTO<Object>> updatePost(@PathVariable Long id, @RequestBody PostVO postVO){
        postService.update(postVO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("게시판 수정 완료"));
    }

    @DeleteMapping("delete/{id}")
    public void deletePost(@PathVariable Long id){
        postService.delete(id);
    }

}
