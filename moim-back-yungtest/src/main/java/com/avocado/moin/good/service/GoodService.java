package com.avocado.moin.good.service;

import com.avocado.moin.good.domain.Good;
import com.avocado.moin.good.dto.GoodDto;
import com.avocado.moin.good.repository.GoodRepository;
import com.avocado.moin.post.domain.Post;
import com.avocado.moin.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class GoodService {

    private final GoodRepository likeclickRepository;
    private final PostRepository postRepository;


    @Transactional
    public void likeClick(GoodDto likeClickDto) {

//        // 이미 좋아요 된 캠페인일 경우 409 에러
//        if (ffindLikeClickWithPostId(likeClickDto).isPresent())
//            throw new CustomException(ALREADY_HEARTED);

        log.info("add likeClick");
        try {
            likeclickRepository.save(likeClickDto.toEntity()).getId();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional
    public void unlikeClick(GoodDto likeClickDto) {

        log.info("unlikeClick");
        Optional<Good> likeClickOpt = findLikeClickWithPostAndUserId(likeClickDto);
        
//        if (likeClickOpt.isEmpty())
//            throw new CustomSQLExceptionTranslatorRegistrar(LIKECLICK_NOT_FOUND);

        try {
        likeclickRepository.delete(likeClickOpt.get());
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    public Optional<Good> findLikeClickWithPostAndUserId(GoodDto likeClickDto) {
        Optional<Post> postOpt = postRepository.findById(likeClickDto.getPostId());
//        if (postOpt.isEmpty())
//            throw new CustomException(MEMBER_NOT_FOUND);

        return likeclickRepository.GoodClickWithPostAndUserId(postOpt.get(), likeClickDto.getUserId());
    }
}
