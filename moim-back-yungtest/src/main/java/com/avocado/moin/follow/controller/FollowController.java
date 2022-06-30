package com.avocado.moin.follow.controller;

import com.avocado.moin.follow.domain.Follow;
import com.avocado.moin.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class FollowController {

    private final FollowService followService;

    @PostMapping("/follow")
    public void saveFollow(@RequestBody Follow follow){ followService.addFollow(follow);}

    @GetMapping("/follow")
    public List<Follow> findAllFollow(){return followService.findAllFollow();}

    @DeleteMapping("/follow/{id}")
    public void delFollow(@PathVariable Long id, @RequestBody Follow follow){ followService.delFollow(id);}
}
