package com.avocado.moin.hashtag.controller;

import com.avocado.moin.hashtag.domain.Hashtag;
import com.avocado.moin.hashtag.hashtagDto.HashtagAddDto;
import com.avocado.moin.hashtag.hashtagDto.HashtagResponseDto;
import com.avocado.moin.hashtag.service.HashtagService;
import com.avocado.moin.post.domain.Post;
import com.avocado.moin.post.dto.PostAddDto;
import com.avocado.moin.post.dto.PostResponseDto;
import com.avocado.moin.post.dto.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class HashtagController {

    private final HashtagService hashtagService;

    @PostMapping("/hashtag")
    public void savePost(@RequestBody HashtagAddDto hashtagAddDto) {
        hashtagService.addHashtag(hashtagAddDto);
    }

    @PutMapping("/hashtag/{id}")
    public void editHashtag(@PathVariable Long id, @RequestBody HashtagAddDto hashtagAddDto) {
        hashtagService.editHashtag(id, hashtagAddDto);
    }

    @GetMapping("/hashtag")
    public List<Hashtag> findAllHashtag() {
        return hashtagService.findAllHashtag();
    }

    @GetMapping("/hashtag/{id}")
    public HashtagResponseDto findById(@PathVariable Long id) {
        return hashtagService.findById(id);
    }

    @DeleteMapping("/hashtag/{id}")
    public void delHashtag(@PathVariable Long id) {
        hashtagService.delHashtag(id);
    }
}