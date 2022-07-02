package com.avocado.moin.tagList.dto;

import com.avocado.moin.tagList.domain.TagList;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TagListResponseDto {
    private Long Id;
    private Long postId;
    private Long hashtagId;

    @Builder
    public TagListResponseDto(TagList entity){
        this.Id = entity.getId();
        this.postId = entity.getPost().getId();
        this.hashtagId = entity.getId();
    }
}
