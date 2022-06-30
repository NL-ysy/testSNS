package com.avocado.moin.follow.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long userId;
    private Long follower;

    @Builder
    public Follow(Long userId, Long follower) {
        this.userId = userId;
        this.follower = follower;
    }
}