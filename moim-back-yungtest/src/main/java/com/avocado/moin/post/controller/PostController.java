package com.avocado.moin.post.controller;

import com.avocado.moin.post.dto.PostAddDto;
import com.avocado.moin.post.dto.PostResponseDto;
import com.avocado.moin.post.dto.PostUpdateDto;
import com.avocado.moin.post.domain.Post;
import com.avocado.moin.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public void savePost(@RequestBody PostAddDto postAddDto, MultipartFile multipartFile) {
        postService.addPost(postAddDto);
    }

    @PutMapping("/post/{id}")
    public void editPost(@PathVariable Long id, @RequestBody PostUpdateDto postUpdateDto) {
        postService.editPost(id, postUpdateDto);
    }

    @GetMapping("/post")
    public List<Post> findAllPost() {
        return postService.findAllPost();
    }

    @GetMapping("/post/{id}")
    public PostResponseDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @DeleteMapping("/post/{id}")
    public void delPost(@PathVariable Long id) {
        postService.delPost(id);
    }
}
