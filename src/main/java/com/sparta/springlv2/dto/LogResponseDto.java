package com.sparta.springlv2.dto;

import com.sparta.springlv2.entity.Book;
import com.sparta.springlv2.entity.Rent;
import com.sparta.springlv2.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class LogResponseDto {
    private Long bookId;
    private Long userId;
    private boolean returned;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String name;
    private String phone;
    private String title;
    private String writer;

    public LogResponseDto(Rent rent, User user, Book book) {
        this.bookId = rent.getBookId();
        this.userId = rent.getUserId();
        this.returned = rent.isReturned();
        this.createdAt = rent.getCreatedAt();
        this.modifiedAt = rent.getModifiedAt();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.title = book.getTitle();
        this.writer = book.getWriter();
    }

}
