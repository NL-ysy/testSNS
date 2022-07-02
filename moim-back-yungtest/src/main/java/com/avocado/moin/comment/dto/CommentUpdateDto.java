package com.avocado.moin.comment.dto;

import com.avocado.moin.comment.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentUpdateDto {

    private Long id;
    private String content;

    @Builder
    public CommentUpdateDto(String content){
        this.content = content;
    }
}
