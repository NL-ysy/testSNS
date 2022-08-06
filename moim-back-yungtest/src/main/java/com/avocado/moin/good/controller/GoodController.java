package com.avocado.moin.good.controller;

import com.avocado.moin.good.dto.GoodDto;
import com.avocado.moin.good.service.GoodService;
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
public class GoodController {

    private final GoodService likeClickService;


    @PostMapping("/likeClick")
    public ResponseEntity<GoodDto> likeClick(@RequestBody @Validated GoodDto likeClickDto) {
        likeClickService.likeClick(likeClickDto);
        return new ResponseEntity<>(likeClickDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/likeClick")
    public ResponseEntity<GoodDto> unLikeClick(@RequestBody @Validated GoodDto likeClickDto) {
        likeClickService.unlikeClick(likeClickDto);
        return new ResponseEntity<>(likeClickDto, HttpStatus.OK);
    }
}
