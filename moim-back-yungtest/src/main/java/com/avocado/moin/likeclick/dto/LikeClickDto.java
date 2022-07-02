package com.avocado.moin.likeclick.dto;

import com.avocado.moin.likeclick.domain.Likeclick;
import com.avocado.moin.post.repository.PostRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LikeClickDto {

    private Long postId;
    private Long userId;

    private PostRepository postRepository;

    public Likeclick toEntity(){
        return Likeclick.builder()
                .post(postRepository.findById(postId).get())
                .userId(userId)
                .build();
    }
}
