package com.avocado.moin.block.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long userId;
    private Long blockedid;

    public void update(Long blockedid){
        this.blockedid = blockedid;
    }

    @Builder
    public Block(Long blockedid) {
        this.blockedid = blockedid;
    }
}

