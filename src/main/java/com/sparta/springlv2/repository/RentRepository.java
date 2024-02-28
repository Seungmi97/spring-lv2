package com.sparta.springlv2.repository;

import com.sparta.springlv2.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Long> {
}
