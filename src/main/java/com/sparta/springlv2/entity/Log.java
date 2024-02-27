package com.sparta.springlv2.entity;

import com.sparta.springlv2.dto.LogRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "log")
@NoArgsConstructor
public class Log extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bookId")
    private Long bookId;
    @Column(name = "userId")
    private Long userId;
    @Column(name = "returned")
    private boolean returned;

    public Log(LogRequestDto logRequestDto) {
        this.bookId = logRequestDto.getBookId();
        this.userId = logRequestDto.getUserId();
        this.returned = logRequestDto.isReturned();
    }
}
