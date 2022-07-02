package com.avocado.moin.likeclick.controller;

import com.avocado.moin.likeclick.dto.LikeClickDto;
import com.avocado.moin.likeclick.repository.LikeclickRepository;
import com.avocado.moin.likeclick.service.LikeClickService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LikeClickController {

    private final LikeClickService likeClickService;


    @PostMapping("/likeClick")
    public ResponseEntity<LikeClickDto> likeClick(@RequestBody @Validated LikeClickDto likeClickDto) {
        likeClickService.likeClick(likeClickDto);
        return new ResponseEntity<>(likeClickDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/likeClick")
    public ResponseEntity<LikeClickDto> unLikeClick(@RequestBody @Validated LikeClickDto likeClickDto) {
        likeClickService.unlikeClick(likeClickDto);
        return new ResponseEntity<>(likeClickDto, HttpStatus.OK);
    }
}
