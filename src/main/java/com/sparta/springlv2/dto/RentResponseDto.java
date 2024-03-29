package com.sparta.springlv2.dto;

import com.sparta.springlv2.entity.Rent;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RentResponseDto {
    private Long bookId;
    private Long userId;
    private boolean returned;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public RentResponseDto(Rent rent) {
        this.bookId = rent.getBookId();
        this.userId = rent.getUserId();
        this.returned = rent.isReturned();
        this.createdAt = rent.getCreatedAt();
        this.modifiedAt = rent.getModifiedAt();
    }
}
