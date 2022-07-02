package com.avocado.moin.block.dto;

import com.avocado.moin.block.domain.Block;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BlockAddDto {

    private Long Id;
    private Long userId;
    private Long blockedid;

    public Block toEntity(){
        return Block.builder()
                .blockedid(blockedid)
                .build();
    }

    @Builder
    public BlockAddDto(Long userId, Long blockedid) {
        this.userId = userId;
        this.blockedid = blockedid;
    }
}
