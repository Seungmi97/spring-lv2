package com.sparta.springlv2.repository;

import com.sparta.springlv2.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
