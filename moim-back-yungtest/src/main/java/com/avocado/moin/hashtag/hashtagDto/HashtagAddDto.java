package com.avocado.moin.hashtag.hashtagDto;

import com.avocado.moin.hashtag.domain.Hashtag;
import com.avocado.moin.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class HashtagAddDto {
    private Long id;
    private String text;


    public Hashtag toEntity(){
        return Hashtag.builder()
                .text(text)
                .build();
    }

    @Builder
    public HashtagAddDto(String text) {
        this.text = text;
    }
}

