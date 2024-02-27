package com.sparta.springlv2.entity;

import com.sparta.springlv2.dto.BookRequestDto;
import com.sparta.springlv2.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private char gender;
    @Column(name = "rrn", unique = true)
    private String rrn;
    @Column(name = "phone", unique = true)
    private String phone;
    @Column(name = "addr")
    private String addr;

    public User(UserRequestDto userRequestDto) {
        this.name = name;
        this.gender = gender;
        this.rrn = rrn;
        this.phone = phone;
        this.addr = addr;
    }
}
