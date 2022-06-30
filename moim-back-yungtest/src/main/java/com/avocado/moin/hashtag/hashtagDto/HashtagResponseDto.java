package com.avocado.moin.hashtag.hashtagDto;

import com.avocado.moin.hashtag.domain.Hashtag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class HashtagResponseDto {
    private Long id;
    private String text;


    @Builder
    public HashtagResponseDto(Hashtag entity) {
       this.id = entity.getId();
       this.text = entity.getText();
    }
}

