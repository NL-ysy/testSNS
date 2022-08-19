package com.avocado.moin.post.dto;

import com.avocado.moin.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostAddDto {

    private Long id;
    private String url;
    private Long userId;
    private String title;
    private String content;
    private String address1;
    private String address2;

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .address1(address1)
                .address2(address2)
                .build();
    }

    @Builder
    public PostAddDto(Long userId, String title, String content, String address1, String address2) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.address1 = address1;
        this.address2 = address2;
    }
}

