package com.avocado.moin.followList.controller;

import com.avocado.moin.followList.domain.FollowList;
import com.avocado.moin.followList.dto.FollowListAddDto;
import com.avocado.moin.followList.dto.FollowListRepositoryDto;
import com.avocado.moin.followList.service.FollowListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class FollowListController {

    private final FollowListService followListService;

    @PostMapping("/followList")
    public void saveFollowList(@RequestBody FollowListAddDto followListAddDto){
        followListService.addFollowList(followListAddDto);
    }

    @PutMapping("/followList/{id}")
    public void editFollowList(@PathVariable Long id, @RequestBody FollowListAddDto followListAddDto){
        followListService.editFollowList(id, followListAddDto);
    }

    @GetMapping("/followList")
    public List<FollowList> findAllFollowList(){return followListService.findAllFollowList();}

    @GetMapping("followList/{id}")
    public FollowListRepositoryDto findById(@PathVariable Long id){return followListService.findById(id);}

    @DeleteMapping("/followList/{id}")
    public void delFollowList(@PathVariable Long id){
        followListService.delFollowList(id);
    }
}
