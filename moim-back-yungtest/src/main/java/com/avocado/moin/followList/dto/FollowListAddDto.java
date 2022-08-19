package com.avocado.moin.followList.dto;

import com.avocado.moin.follow.repository.FollowRepository;
import com.avocado.moin.followList.domain.FollowList;
import com.avocado.moin.user.repository.UserRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@Getter
public class FollowListAddDto {

    private Long Id;
    private Long userId;
    private Long followerId;

    @Autowired
    private FollowRepository followRepository;
    @Autowired
    private UserRepository userRepository;

    public FollowList toEntity(){
        return FollowList.builder()
                .follow(followRepository.findById(followerId).get())
                .user(userRepository.findById(userId).get())
                .build();
    }

    public void update(Long followerId, Long userId){
        this.followerId = followerId;
        this.userId = userId;
    }

    @Builder
    public FollowListAddDto(Long userId, Long followerId) {
        this.userId = userId;
        this.followerId = followerId;
    }
}
