package com.avocado.moin.controller;

import com.avocado.moin.post.controller.PostController;
import com.avocado.moin.post.domain.Post;
import com.avocado.moin.post.dto.PostUpdateDto;
import com.avocado.moin.post.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import javax.persistence.Id;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//controller를 사용할 수 있는 테스트 어노테이션
//단위테스트용으로 @WebMvcTest, @DataJpaTest, @RestClientTest, @JsonTest 등등을 사용함
//@WebMvcTest(controllers = PostController.class)

@SpringBootTest //통합 테스트용
public class PostControllerTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void Post_추가() throws Exception{
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

    @Test
    public void Post수정(){
        //given

        String title = "테스트 게시글 제목";
        String content = "테스트 게시글 본문";
        String location = "테스트 게시글 위치정보";

        Post savePost = postRepository.save(Post.builder()
                .title(title)
                .content(content)
                .location(location)
                .build());

        Long id = savePost.getId(); //id 지정
        String expectedtitle = "테스트 게시글 수정 제목";
        String expectedcontent = "테스트 게시글 수정 본문";
        String expectedlocation = "테스트 게시글 수정한 위치정보";

        PostUpdateDto updateDto = PostUpdateDto.builder()
                .title(expectedtitle)
                .content(expectedcontent)
                .location(expectedlocation).build();

        String url = "http://localhost:8080/api/post/" + id;
        HttpEntity<PostUpdateDto> requestEntity = new HttpEntity<>(updateDto);


        //when
        List<Post> postList = postRepository.findAll();
//        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        Post post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
        assertThat(post.getLocation()).isEqualTo(location);
    }
}
