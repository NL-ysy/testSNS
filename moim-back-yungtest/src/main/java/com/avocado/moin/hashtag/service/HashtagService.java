package com.avocado.moin.hashtag.service;

import com.avocado.moin.hashtag.domain.Hashtag;
import com.avocado.moin.hashtag.hashtagDto.HashtagAddDto;
import com.avocado.moin.hashtag.hashtagDto.HashtagResponseDto;
import com.avocado.moin.hashtag.repository.HashtagRepository;
import com.avocado.moin.post.domain.Post;
import com.avocado.moin.post.dto.PostAddDto;
import com.avocado.moin.post.dto.PostResponseDto;
import com.avocado.moin.post.dto.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class HashtagService {

    private final HashtagRepository hashtagRepository;

    @Transactional
    public void addHashtag(HashtagAddDto hashtagAddDto) {
        log.info("add Hashtag");
        try {
            hashtagRepository.save(hashtagAddDto.toEntity()).getId();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }
    @Transactional
    public void editHashtag(Long id, HashtagAddDto hashtagAddDto) {
        log.info("edit hashtag {}.");
        Hashtag hashtag = hashtagRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("error"));
        hashtag.update(hashtagAddDto.getText());
    }

    @Transactional
    public void delHashtag(Long id) {
        log.info("delete Hashtag by Id {}.", id);
        try {
            hashtagRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public List<Hashtag> findAllHashtag() {
        return hashtagRepository.findAll();
    }

    @Transactional(readOnly = true)
    public HashtagResponseDto findById(Long id) {
        log.info("find by hashtag id : {}", id);
        Hashtag hashtag = hashtagRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id ="+ id));

        return new HashtagResponseDto(hashtag);
    }
}

