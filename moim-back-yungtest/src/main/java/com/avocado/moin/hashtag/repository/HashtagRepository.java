package com.avocado.moin.hashtag.repository;

import com.avocado.moin.hashtag.domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashtagRepository extends JpaRepository<Hashtag,Long> {
}
