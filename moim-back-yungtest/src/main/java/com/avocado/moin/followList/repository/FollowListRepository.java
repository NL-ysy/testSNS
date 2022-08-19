package com.avocado.moin.followList.repository;

import com.avocado.moin.followList.domain.FollowList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowListRepository extends JpaRepository<FollowList, Long> {
}
