package com.avocado.moin.user.repository;

import com.avocado.moin.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
