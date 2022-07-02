package com.avocado.moin.likeclick.repository;

import com.avocado.moin.likeclick.domain.Likeclick;
import com.avocado.moin.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeclickRepository extends JpaRepository<Likeclick, Long> {

    Optional<Likeclick> findLikeClickWithPostAndUserId(Post post, Long userId);
}
