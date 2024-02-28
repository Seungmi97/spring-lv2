package com.sparta.springlv2.repository;

import com.sparta.springlv2.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findAllByBookId(Long id);
    List<Rent> findAllByUserId(Long id);
    List<Rent> findAllByUserIdOrderByCreatedAt(Long id);
    List<Rent> findAllByUserIdAndBookId(Long userId, Long bookId);
}
