package com.sparta.springlv2.dto;

import com.sparta.springlv2.entity.Book;
import lombok.Getter;

@Getter
public class BookResponseDto {
    private String title;
    private String writer;
    private String language;
    private String publisher;

    public BookResponseDto(Book book) {
        this.title = book.getTitle();
        this.writer = book.getWriter();
        this.language = book.getLanguage();
        this.publisher = book.getPublisher();
    }
}
