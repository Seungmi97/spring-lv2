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
    @Column(name = "idNumber", unique = true)
    private String idNumber;
    @Column(name = "phone", unique = true)
    private String phone;
    @Column(name = "address")
    private String address;

    public User(UserRequestDto userRequestDto) {
        this.name = userRequestDto.getName();
        this.gender = userRequestDto.getGender();
        this.idNumber = userRequestDto.getIdNumber();
        this.phone = userRequestDto.getPhone();
        this.address = userRequestDto.getAddress();
    }
}
