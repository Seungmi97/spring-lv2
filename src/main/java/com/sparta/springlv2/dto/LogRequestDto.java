package com.sparta.springlv2.dto;

import lombok.Getter;

@Getter
public class LogRequestDto {
    private Long bookId;
    private Long userId;
    private boolean status;
}
