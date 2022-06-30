package com.avocado.moin.post.service;


import com.avocado.moin.post.dto.PostAddDto;
import com.avocado.moin.post.dto.PostResponseDto;
import com.avocado.moin.post.dto.PostUpdateDto;
import com.avocado.moin.post.domain.Post;
import com.avocado.moin.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void addPost(PostAddDto postAddDto) {
        log.info("add Post");
        try {
            postRepository.save(postAddDto.toEntity()).getId();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional
    public void editPost(Long id, PostUpdateDto postDto) {
        log.info("edit post {}.");
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("error"));
        post.update(postDto.getTitle(), postDto.getContent(), postDto.getLocation());
    }


    @Transactional
    public void delPost(Long id) {
        log.info("delete Sns by Id {}.", id);
        try {
            postRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PostResponseDto findById(Long id) {
        log.info("find by post id : {}", id);
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id ="+ id));

        return new PostResponseDto(post);
    }
}