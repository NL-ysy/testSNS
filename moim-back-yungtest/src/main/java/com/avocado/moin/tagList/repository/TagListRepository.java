package com.avocado.moin.tagList.repository;

import com.avocado.moin.tagList.domain.TagList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagListRepository extends JpaRepository<TagList, Long> {
}
