package com.avocado.moin.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Getter
public class PostUpdateDto {

    private String title;
    private String content;
    private String address1;
    private String address2;

    @Builder
    public PostUpdateDto(String title, String content, String address1, String address2) {
        this.title = title;
        this.content = content;
        this.address1 = address1;
        this.address2 = address2;
    }
}
