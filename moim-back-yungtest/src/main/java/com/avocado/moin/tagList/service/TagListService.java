package com.avocado.moin.tagList.service;

import com.avocado.moin.post.domain.Post;
import com.avocado.moin.post.dto.PostAddDto;
import com.avocado.moin.post.dto.PostResponseDto;
import com.avocado.moin.post.dto.PostUpdateDto;
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
public class TagListService {

    private final TagListRepository tagListRepository;

    @Transactional
    public void addTagList(TagListAddDto tagListAddDto) {
        log.info("add TagList");
        try {
            tagListRepository.save(tagListAddDto.toEntity()).getId();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional
    public void editTAgList(Long id, TagListAddDto tagListDto) {
        log.info("edit tagList {}.");
        TagList tagList = tagListRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("error"));
        tagList.update(tagListDto.getPostId(), tagListDto.getHashtagId());
    }

    @Transactional
    public void delTagList(Long id) {
        log.info("delete TagList by Id {}.", id);
        try {
            tagListRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public List<TagList> findAllTagList() {
        return tagListRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TagListResponseDto findById(Long id) {
        log.info("find by TagList id : {}", id);
        TagList tagList = tagListRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id ="+ id));

        return new TagListResponseDto(tagList);
    }

}
