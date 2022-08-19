package com.avocado.moin.followList.service;

import com.avocado.moin.follow.repository.FollowRepository;
import com.avocado.moin.followList.domain.FollowList;
import com.avocado.moin.followList.dto.FollowListAddDto;
import com.avocado.moin.followList.dto.FollowListRepositoryDto;
import com.avocado.moin.followList.repository.FollowListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class FollowListService {

    private final FollowListRepository followListRepository;

    @Transactional
    public void addFollowList(FollowListAddDto followListAddDto){
        log.info("add FollowList");
        try{
            followListRepository.save(followListAddDto.toEntity()).getId();
        }catch (Exception e){
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional
    public void editFollowList(Long id, FollowListAddDto followListAddDto){
        log.info("edit FollowList {}", id);
        FollowList followList = followListRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("error"));
        followList.update(followListAddDto.getFollowerId(), followListAddDto.getUserId());
    }

    @Transactional
    public void delFollowList(Long id){
        log.info("delete FollowList by Id {}.", id);
        try{followListRepository.deleteById(id);
        }catch (Exception e){
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public List<FollowList> findAllFollowList(){
        return followListRepository.findAll();
    }

    @Transactional
    public FollowListRepositoryDto findById(Long id){
        log.info("find by FollowList id : {}", id);
        FollowList followList = followListRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("팔로우한 유저가 없습니다. id ="+ id));

        return new FollowListRepositoryDto(followList);
    }
}
