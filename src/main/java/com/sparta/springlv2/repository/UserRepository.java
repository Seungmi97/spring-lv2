package com.sparta.springlv2.repository;

import com.sparta.springlv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUserId(Long id);
}
