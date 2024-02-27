package com.sparta.springlv2.entity;

import com.sparta.springlv2.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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
        this.name = name;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phone = phone;
        this.address = address;
    }

}
