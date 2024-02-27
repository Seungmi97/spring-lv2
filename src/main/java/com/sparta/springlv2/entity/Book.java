package com.sparta.springlv2.entity;

import com.sparta.springlv2.dto.BookRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Table(name = "book")
@NoArgsConstructor
public class Book extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(name = "title")
    private String title;
    @Column(name = "writer")
    private String writer;
    @Column(name = "language")
    private String language;
    @Column(name = "publisher")
    private String publisher;

    public Book(BookRequestDto bookRequestDto) {
        this.title = bookRequestDto.getTitle();
        this.writer = bookRequestDto.getWriter();
        this.language = bookRequestDto.getLanguage();
        this.publisher = bookRequestDto.getPublisher();
    }
}
