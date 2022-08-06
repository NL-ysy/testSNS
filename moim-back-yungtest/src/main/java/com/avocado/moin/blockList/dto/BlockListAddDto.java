package com.avocado.moin.blockList.dto;

import com.avocado.moin.block.repository.BlockRepository;
import com.avocado.moin.blockList.domain.BlockList;
import com.avocado.moin.hashtag.repository.HashtagRepository;
import com.avocado.moin.post.repository.PostRepository;
import com.avocado.moin.tagList.domain.TagList;
import com.avocado.moin.user.repository.UserRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@Getter
public class BlockListAddDto {
    private Long Id;
    private Long blockId;
    private Long userId;

    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private UserRepository userRepository;


    public BlockList toEntity(){
        return BlockList.builder()
                .block(blockRepository.findById(blockId).get())
                .user(userRepository.findById(userId).get())
                .build();
    }

    public void update(Long blockId, Long userId){
        this.blockId = blockId;
        this.userId = userId;
    }

    @Builder
    public BlockListAddDto(Long blockId, Long userId) {
        this.blockId = blockId;
        this.userId = userId;
    }
}
