package com.avocado.moin.user.userMedia.repository;

import com.avocado.moin.user.userMedia.domain.UserMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMediaRepository extends JpaRepository<UserMedia, Long> {
}
