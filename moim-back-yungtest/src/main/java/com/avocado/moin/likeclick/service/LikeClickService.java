package com.avocado.moin.likeclick.service;

import com.avocado.moin.likeclick.domain.Likeclick;
import com.avocado.moin.likeclick.dto.LikeClickDto;
import com.avocado.moin.likeclick.repository.LikeclickRepository;
import com.avocado.moin.post.domain.Post;
import com.avocado.moin.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class LikeClickService {

    private final LikeclickRepository likeclickRepository;
    private final PostRepository postRepository;


    @Transactional
    public void likeClick(LikeClickDto likeClickDto) {

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
    public void unlikeClick(LikeClickDto likeClickDto) {

        log.info("unlikeClick");
        Optional<Likeclick> likeClickOpt = findLikeClickWithPostAndUserId(likeClickDto);
        
//        if (likeClickOpt.isEmpty())
//            throw new CustomSQLExceptionTranslatorRegistrar(LIKECLICK_NOT_FOUND);

        try {
        likeclickRepository.delete(likeClickOpt.get());
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    public Optional<Likeclick> findLikeClickWithPostAndUserId(LikeClickDto likeClickDto) {
        Optional<Post> postOpt = postRepository.findById(likeClickDto.getPostId());
//        if (postOpt.isEmpty())
//            throw new CustomException(MEMBER_NOT_FOUND);

        return likeclickRepository.findLikeClickWithPostAndUserId(postOpt.get(), likeClickDto.getUserId());
    }
}
