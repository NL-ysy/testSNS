package com.avocado.moin.follow.service;

import com.avocado.moin.follow.domain.Follow;
import com.avocado.moin.follow.dto.FollowAddDto;
import com.avocado.moin.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class FollowService {

    private final FollowRepository followRepository;

    @Transactional
    public void addFollow(FollowAddDto followAddDto){
        log.info("add Follower");
        try{followRepository.save(followAddDto.toEntity()).getId();
        }catch (Exception e){
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional
    public void delFollow(Long id){
        log.info("delete Follower by Id {}", id);
        try{followRepository.deleteById(id);
        }catch (Exception e){
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional
    public List<Follow> findAllFollow(){return followRepository.findAll();}

}
