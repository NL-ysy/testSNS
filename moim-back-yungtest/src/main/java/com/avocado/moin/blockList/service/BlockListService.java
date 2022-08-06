package com.avocado.moin.blockList.service;

import com.avocado.moin.blockList.domain.BlockList;
import com.avocado.moin.blockList.dto.BlockListAddDto;
import com.avocado.moin.blockList.dto.BlockListResponseDto;
import com.avocado.moin.blockList.repository.BlockListRepository;
import com.avocado.moin.tagList.domain.TagList;
import com.avocado.moin.tagList.dto.TagListAddDto;
import com.avocado.moin.tagList.dto.TagListResponseDto;
import com.avocado.moin.tagList.repository.TagListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BlockListService {

    private final BlockListRepository blockListRepository;

    @Transactional
    public void addBlockList(BlockListAddDto blockListAddDto) {
        log.info("add BlockList");
        try {
            blockListRepository.save(blockListAddDto.toEntity()).getId();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional
    public void editBlockList(Long id, BlockListAddDto blockListAddDto) {
        log.info("edit blockList {}.");
        BlockList blockList = blockListRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("error"));
        blockList.update(blockListAddDto.getBlockId(), blockListAddDto.getUserId());
    }

    @Transactional
    public void delBlockList(Long id) {
        log.info("delete BlockList by Id {}.", id);
        try {
            blockListRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public List<BlockList> findAllBlockList() {
        return blockListRepository.findAll();
    }

    @Transactional(readOnly = true)
    public BlockListResponseDto findById(Long id) {
        log.info("find by BlockList id : {}", id);
        BlockList blockList = blockListRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("블락한 유저가 없습니다. id ="+ id));

        return new BlockListResponseDto(blockList);
    }

}

