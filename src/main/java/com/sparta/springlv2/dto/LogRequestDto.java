package com.sparta.springlv2.dto;

import lombok.Getter;

@Getter
public class LogRequestDto {
    private Long bookId; //도서식별값
    private Long userId; //회원식별값
    private boolean returned; //반납상태
}
