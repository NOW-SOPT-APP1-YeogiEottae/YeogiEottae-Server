package com.joinseminar.yeogieottae.domain.user.repository;

import com.joinseminar.yeogieottae.domain.user.model.User;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    Optional<User> findById(Long userId);
}
