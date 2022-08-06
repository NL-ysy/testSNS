package com.avocado.moin.blockList.dto;

import com.avocado.moin.blockList.domain.BlockList;
import com.avocado.moin.tagList.domain.TagList;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BlockListResponseDto {
    private Long Id;
    private Long blockId;
    private Long userId;

    @Builder
    public BlockListResponseDto(BlockList entity){
        this.Id = entity.getId();
        this.blockId = entity.getBlock().getId();
        this.userId = entity.getUser().getId();
    }
}
