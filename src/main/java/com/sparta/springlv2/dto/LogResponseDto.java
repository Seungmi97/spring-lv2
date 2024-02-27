package com.sparta.springlv2.dto;

import com.sparta.springlv2.entity.Log;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LogResponseDto {
    private Long bookId;
    private Long userId;
    private boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String name;
    private String phone;
    private String title;
    private String writer;

    public LogResponseDto(Log log) {
        this.bookId = log.getBookId();
        this.userId = log.getUserId();
        this.status = log.isStatus();
        this.createdAt = log.getCreatedAt();
        this.modifiedAt = log.getModifiedAt();
//        this.name = name;
//        this.phone = phone;
//        this.title = title;
//        this.writer = writer;
    }
}
