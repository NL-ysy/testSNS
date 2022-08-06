package com.avocado.moin.good.repository;

import com.avocado.moin.good.domain.Good;
import com.avocado.moin.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoodRepository extends JpaRepository<Good, Long> {

    Optional<Good> GoodClickWithPostAndUserId(Post post, Long userId);
}
