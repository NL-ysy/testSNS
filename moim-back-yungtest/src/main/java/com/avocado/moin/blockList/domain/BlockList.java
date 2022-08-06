package com.avocado.moin.blockList.domain;

import com.avocado.moin.block.domain.Block;
import com.avocado.moin.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class BlockList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "block_id")
    private Block block;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;

    public void update(Long blockId, Long userId){
        this.block = block;
        this.user = user;
    }

    @Builder
    public BlockList(Block block, User user) {
        this.block = block;
        this.user = user;
    }
}