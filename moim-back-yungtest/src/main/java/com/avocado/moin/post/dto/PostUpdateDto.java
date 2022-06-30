package com.avocado.moin.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Getter
public class PostUpdateDto {

    private String title;
    private String content;
    private String location;

    @Builder
    public PostUpdateDto(String title, String content, String location) {
        this.title = title;
        this.content = content;
        this.location = location;
    }
}
