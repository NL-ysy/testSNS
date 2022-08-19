package com.avocado.moin.followList.dto;

import com.avocado.moin.followList.domain.FollowList;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FollowListRepositoryDto {

    private Long Id;
    private Long followId;
    private Long userId;

    @Builder
    public FollowListRepositoryDto(FollowList entity) {
        this.Id = entity.getId();
        this.followId = entity.getFollow().getId();
        this.userId = entity.getUser().getId();
    }
}
