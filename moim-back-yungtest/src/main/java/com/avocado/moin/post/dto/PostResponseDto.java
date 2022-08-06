package com.avocado.moin.post.dto;

import com.avocado.moin.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String location1;
    private String location2;

    @Builder
    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.location1 = entity.getLocation1();
        this.location2 = entity.getLocation2();
    }
}