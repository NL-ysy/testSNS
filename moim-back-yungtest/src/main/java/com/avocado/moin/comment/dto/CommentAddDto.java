package com.avocado.moin.comment.dto;

import com.avocado.moin.comment.domain.Comment;
import com.avocado.moin.post.repository.PostRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@Getter
public class CommentAddDto {

    private Long id;
    private Long postId;
    private String content;

    @Autowired
    private PostRepository postRepository;

    public Comment toEntity(){
        return Comment.builder()
                .post(postRepository.findById(postId).get())
                .content(content)
                .build();
    }

    @Builder
    public CommentAddDto(Long postId, String content){
        this.postId = postId;
        this.content = content;
    }
}
