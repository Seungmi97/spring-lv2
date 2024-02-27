package com.sparta.springlv2.entity;

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
    @Column(name = "status")
    private boolean status;
}
