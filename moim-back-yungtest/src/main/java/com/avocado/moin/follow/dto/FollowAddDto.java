package com.avocado.moin.follow.dto;

import com.avocado.moin.follow.domain.Follow;
import lombok.Builder;

public class FollowAddDto {

    private Long Id;
    private Long userId;
    private Long follower;

    public Follow toEntity(){
        return Follow.builder()
                .follower(follower)
                .build();
    }

    @Builder
    public FollowAddDto(Long userId, Long follower) {
        this.userId = userId;
        this.follower = follower;
    }
}
