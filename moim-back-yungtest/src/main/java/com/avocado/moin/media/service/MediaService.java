package com.avocado.moin.media.service;

import com.avocado.moin.comment.domain.Comment;
import com.avocado.moin.comment.dto.CommentAddDto;
import com.avocado.moin.comment.dto.CommentUpdateDto;
import com.avocado.moin.media.domain.Media;
import com.avocado.moin.media.dto.MediaAddDto;
import com.avocado.moin.media.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MediaService {

    private final MediaRepository mediaRepository;

    @Transactional
    public void addMedia(MediaAddDto mediaAddDto){
        log.info("add Media");
        try{mediaRepository.save(mediaAddDto.toEntity()).getId();
        }catch (Exception e){
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional
    public void editMedia(Long id, MediaAddDto mediaAddDto){
        log.info("edit Media {}.");
        Media media = mediaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("error"));
        media.update(mediaAddDto.getMedia());
    }

    @Transactional
    public void delMedia(Long id){
        log.info("delete Media by Id {}.", id);
        try{mediaRepository.deleteById(id);
        }catch (Exception e){
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional
    public List<Media> findAllMedia(){return mediaRepository.findAll();}
}
