package com.avocado.moin.comment.controller;

import com.avocado.moin.comment.domain.Comment;
import com.avocado.moin.comment.dto.CommentAddDto;
import com.avocado.moin.comment.dto.CommentUpdateDto;
import com.avocado.moin.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment")
    public void saveComment(@RequestBody CommentAddDto commentAddDto){
        commentService.addComment(commentAddDto);
    }

    @PutMapping("/comment/{id}")
    public void editComment(@PathVariable Long id, @RequestBody CommentUpdateDto commentUpdateDto){
        commentService.editComment(id, commentUpdateDto);
    }
    @GetMapping("/comment")
    public List<Comment> findAllComment(){
        return commentService.findAllComment();
    }
    @DeleteMapping("/comment/{id}")
    public void delComment(@PathVariable Long id) {commentService.delComment(id);}
}
