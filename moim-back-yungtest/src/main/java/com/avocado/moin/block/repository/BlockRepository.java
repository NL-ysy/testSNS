package com.avocado.moin.block.repository;

import com.avocado.moin.block.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
