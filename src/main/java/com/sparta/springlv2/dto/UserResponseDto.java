package com.sparta.springlv2.dto;

import com.sparta.springlv2.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String name;
    private char gender;
    private String phone;
    private String addr;

    public UserResponseDto(User user) {
        this.name = user.getName();
        this.gender = user.getGender();
        this.phone = user.getPhone();
        this.addr = user.getAddr();
    }
}
