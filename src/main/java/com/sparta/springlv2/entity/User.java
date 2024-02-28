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
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "gender", nullable = false)
    private char gender;
    @Column(name = "idNumber", nullable = false, unique = true)
    private String idNumber;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @Column(name = "address", nullable = false)
    private String address;

    public User(UserRequestDto userRequestDto) {
        this.name = userRequestDto.getName();
        this.gender = userRequestDto.getGender();
        this.idNumber = userRequestDto.getIdNumber();
        this.phone = userRequestDto.getPhone();
        this.address = userRequestDto.getAddress();
    }

}
