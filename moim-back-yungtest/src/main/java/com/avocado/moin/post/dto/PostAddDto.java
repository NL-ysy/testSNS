package com.avocado.moin.post.dto;

import com.avocado.moin.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostAddDto {

    private Long id;
    private Long userId;
    private String title;
    private String content;
    private String location1;
    private String location2;

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .location1(location1)
                .location2(location2)
                .build();
    }

    @Builder
    public PostAddDto(Long userId, String title, String content, String location1, String location2) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.location1 = location1;
        this.location2 = location2;
    }
}

