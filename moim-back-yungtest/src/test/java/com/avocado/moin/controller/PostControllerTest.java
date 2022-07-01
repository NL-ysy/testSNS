package com.avocado.moin.controller;

import com.avocado.moin.post.domain.Post;
import com.avocado.moin.post.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostControllerTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void addPost(){
        //given
        String title = "테스트 게시글 제목";
        String content = "테스트 게시글 본문";
        String location = "테스트 게시글 위치정보";

        postRepository.save(Post.builder()
                .title(title)
                .content(content)
                .location(location)
                .build());

        //when
        List<Post> postList = postRepository.findAll();

        //then
        Post post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
        assertThat(post.getLocation()).isEqualTo(location);
    }
}
