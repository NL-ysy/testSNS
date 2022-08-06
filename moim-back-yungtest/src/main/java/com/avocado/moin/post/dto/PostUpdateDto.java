package com.avocado.moin.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Getter
public class PostUpdateDto {

    private String title;
    private String content;
    private String location1;
    private String location2;

    @Builder
    public PostUpdateDto(String title, String content, String location1, String location2) {
        this.title = title;
        this.content = content;
        this.location1 = location1;
        this.location2 = location2;
    }
}
