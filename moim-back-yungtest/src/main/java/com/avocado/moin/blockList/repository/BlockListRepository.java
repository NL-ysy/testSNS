package com.avocado.moin.blockList.repository;

import com.avocado.moin.blockList.domain.BlockList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockListRepository extends JpaRepository<BlockList, Long> {
}
