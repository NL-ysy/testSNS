package com.avocado.moin.followList.domain;

import com.avocado.moin.block.domain.Block;
import com.avocado.moin.follow.domain.Follow;
import com.avocado.moin.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class FollowList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "follow_id")
    private Follow follow;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;

    public void update(Long followId, Long userId){
        this.follow = follow;
        this.user = user;
    }

    @Builder
    public FollowList(Follow follow, User user) {
        this.follow = follow;
        this.user = user;
    }
}

