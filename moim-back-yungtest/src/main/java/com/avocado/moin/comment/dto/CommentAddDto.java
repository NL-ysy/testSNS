package com.avocado.moin.comment.dto;

import com.avocado.moin.comment.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentAddDto {

    private Long id;
    private Long postId;
    private String content;

    public Comment toEntity(){
        return Comment.builder()
                .postId(postId)
                .content(content)
                .build();
    }

    @Builder
    public CommentAddDto(Long postId, String content){
        this.postId = postId;
        this.content = content;
    }
}
