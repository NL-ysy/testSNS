package com.avocado.moin.post.service;


import com.avocado.moin.likes.repository.LikesRepository;
import com.avocado.moin.post.dto.PostAddDto;
import com.avocado.moin.post.dto.PostResponseDto;
import com.avocado.moin.post.dto.PostUpdateDto;
import com.avocado.moin.post.domain.Post;
import com.avocado.moin.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final LikesRepository likesRepository;


    private String uploadUrl;

//    @Transactional
//    public void save(PostUploadDto postUploadDto, MultipartFile multipartFile, PrincipalDetails principalDetails) {
//        UUID uuid = UUID.randomUUID();
//        String imgFileName = uuid + "_" + multipartFile.getOriginalFilename();
//
//        Path imageFilePath = Paths.get(uploadUrl + imgFileName);
//        try {
//            Files.write(imageFilePath, multipartFile.getBytes());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        postRepository.save(Post.builder()
//                .postImgUrl(imgFileName)
//                .tag(postUploadDto.getTag())
//                .text(postUploadDto.getText())
//                .user(principalDetails.getUser())
//                .likesCount(0)
//                .build());
//    }

    @Transactional
    public void addPost(PostAddDto postAddDto) {
        log.info("add Post");
        try {
//            //파일업로드
//            UUID uuid = UUID.randomUUID();
//            String imgFileName = uuid + "_" + multipartFile.getOriginalFilename();
//            Path imageFilePath = Paths.get(uploadUrl + imgFileName);

            postRepository.save(postAddDto.toEntity()).getId();

        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional
    public void editPost(Long id, PostUpdateDto postDto) {
        log.info("edit post {}.");
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("error"));
        post.update(postDto.getTitle(), postDto.getContent(), postDto.getLocation1(), postDto.getLocation2());
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