package com.avocado.moin.block.service;

import com.avocado.moin.block.domain.Block;
import com.avocado.moin.block.dto.BlockAddDto;
import com.avocado.moin.block.repository.BlockRepository;
import com.avocado.moin.post.domain.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BlockService {

    private final BlockRepository blockRepository;

    @Transactional
    public void addBlock(BlockAddDto blockAddDto){
        log.info("add Block");
        try{
            blockRepository.save(blockAddDto.toEntity()).getId();
        }catch (Exception e){
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public List<Block> findAllBlock() {
        return blockRepository.findAll();
    }

    @Transactional
    public void delBlock(Long id){
        log.info("delete Block User by Id {}.", id);
        try {
            blockRepository.deleteById(id);
        }catch (Exception e){
            log.error("error : {}", e.getMessage());
        }
    }
}
