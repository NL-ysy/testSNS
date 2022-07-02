package com.avocado.moin.tagList.controller;

import com.avocado.moin.post.domain.Post;
import com.avocado.moin.post.dto.PostAddDto;
import com.avocado.moin.post.dto.PostResponseDto;
import com.avocado.moin.post.dto.PostUpdateDto;
import com.avocado.moin.post.service.PostService;
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
public class TagListController {

    private final TagListService tagListService;

    @PostMapping("/tagList")
    public void saveTagList(@RequestBody TagListAddDto tagListAddDto) {
        tagListService.addTagList(tagListAddDto);
    }

    @PutMapping("/tagList/{id}")
    public void editTagList(@PathVariable Long id, @RequestBody TagListAddDto tagListAddDto) {
        tagListService.editTAgList(id, tagListAddDto);
    }

    @GetMapping("/tagList")
    public List<TagList> findAllTagList() {
        return tagListService.findAllTagList();
    }

    @GetMapping("/tagList/{id}")
    public TagListResponseDto findById(@PathVariable Long id) {
        return tagListService.findById(id);
    }

    @DeleteMapping("/tagList/{id}")
    public void delTagList(@PathVariable Long id) {
        tagListService.delTagList(id);
    }
}

