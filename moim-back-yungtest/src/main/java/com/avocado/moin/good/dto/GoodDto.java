package com.avocado.moin.good.dto;

import com.avocado.moin.good.domain.Good;
import com.avocado.moin.post.repository.PostRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GoodDto {

    private Long postId;
    private Long userId;

    private PostRepository postRepository;

    public Good toEntity(){
        return Good.builder()
                .post(postRepository.findById(postId).get())
                .userId(userId)
                .build();
    }
}
