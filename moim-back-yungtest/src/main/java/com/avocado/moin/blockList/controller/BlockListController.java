package com.avocado.moin.blockList.controller;

import com.avocado.moin.blockList.domain.BlockList;
import com.avocado.moin.blockList.dto.BlockListAddDto;
import com.avocado.moin.blockList.dto.BlockListResponseDto;
import com.avocado.moin.blockList.service.BlockListService;
import com.avocado.moin.tagList.domain.TagList;
import com.avocado.moin.tagList.dto.TagListAddDto;
import com.avocado.moin.tagList.dto.TagListResponseDto;
import com.avocado.moin.tagList.service.TagListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BlockListController {

    private final BlockListService blockListService;

    @PostMapping("/blockList")
    public void saveBlockList(@RequestBody BlockListAddDto blockListAddDto) {
        blockListService.addBlockList(blockListAddDto);
    }

    @PutMapping("/blockList/{id}")
    public void editBlockList(@PathVariable Long id, @RequestBody BlockListAddDto blockListAddDto) {
        blockListService.editBlockList(id, blockListAddDto);
    }

    @GetMapping("/blockList")
    public List<BlockList> findAllBlockList() {
        return blockListService.findAllBlockList();
    }

    @GetMapping("/blockList/{id}")
    public BlockListResponseDto findById(@PathVariable Long id) {
        return blockListService.findById(id);
    }

    @DeleteMapping("/blockList/{id}")
    public void delBlockList(@PathVariable Long id) {
        blockListService.delBlockList(id);
    }
}
