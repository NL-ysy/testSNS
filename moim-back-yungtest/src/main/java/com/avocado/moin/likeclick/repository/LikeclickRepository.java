package com.avocado.moin.likeclick.repository;

import com.avocado.moin.likeclick.domain.Likeclick;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeclickRepository extends JpaRepository<Likeclick, Long> {
}
