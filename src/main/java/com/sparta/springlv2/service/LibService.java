package com.sparta.springlv2.service;

import com.sparta.springlv2.dto.UserRequestDto;
import com.sparta.springlv2.dto.UserResponseDto;
import com.sparta.springlv2.entity.User;
import com.sparta.springlv2.repository.BookRepository;
import com.sparta.springlv2.repository.LogRepository;
import com.sparta.springlv2.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibService {

    private final UserRepository userRepository;

    public LibService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    public LibService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

//    public LibService(LogRepository logRepository) {
//        this.logRepository = logRepository;
//    }

    // 회원 등록
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = new User(userRequestDto);

//        User saveUser = UserRepository.save(user);

        UserResponseDto userResponseDto = new UserResponseDto(user);

        return userResponseDto;
    }

//    // 회원 조회
//    public List<UserResponseDto> getUser() {
//        return userRepository.findAllByOrderByCreatedAtDesc().stream().map(UserResponseDto::new).toList();
//    }





}


