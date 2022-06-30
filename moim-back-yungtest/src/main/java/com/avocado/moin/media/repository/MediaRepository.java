package com.avocado.moin.media.repository;

import com.avocado.moin.media.domain.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
