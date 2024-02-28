package com.sparta.springlv2.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {
    private String name; //이름
    private char gender; //성별
    private String idNumber; //주민번호
    private String phone; //휴대폰번호
    private String address; //주소
}
