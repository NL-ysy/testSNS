package com.avocado.moin.comment.service;

import com.avocado.moin.comment.domain.Comment;
import com.avocado.moin.comment.dto.CommentAddDto;
import com.avocado.moin.comment.dto.CommentUpdateDto;
import com.avocado.moin.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public void addComment(CommentAddDto commentAddDto){
        log.info("add Commment");
        try{commentRepository.save(commentAddDto.toEntity()).getId();
        }catch (Exception e){
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional
    public void editComment(Long id, CommentUpdateDto commentUpdateDto){
        log.info("edit comment {}.");
        Comment comment = commentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("error"));
        comment.update(commentUpdateDto.getContent());
    }

    @Transactional
    public void delComment(Long id){
        log.info("delete Comment by Id {}.", id);
        try{commentRepository.deleteById(id);
        }catch (Exception e){
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional
    public List<Comment> findAllComment(){return commentRepository.findAll();}

}
