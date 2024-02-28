package com.sparta.springlv2.controller;

import com.sparta.springlv2.dto.*;
import com.sparta.springlv2.service.LibService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibController {
    private final LibService libService;

    public LibController(LibService libService) {
        this.libService = libService;
    }

    @PostMapping("/book")
    public BookResponseDto registerBook(@RequestBody BookRequestDto requestDto) {
        return libService.registerBook(requestDto);
    }

    @GetMapping("/book")
    public List<BookResponseDto> getBooks() {
        return libService.getBooks();
    }

    @GetMapping("/book/{bookId}")
    public BookResponseDto getBook(@PathVariable Long bookId) {
        return libService.getBookById(bookId);
    }

    // 회원 등록
    @PostMapping("/user")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return libService.createUser(userRequestDto);
    }

//    // 회원 조회
//    @GetMapping("/user")
//    public  List<UserResponseDto> getUser() {
//        return libService.getUser();
//    }

    // 선택 도서 대출
    @PostMapping("/checkout")
    public LogResponseDto bookReturn(@RequestBody LogRequestDto logRequestDto) {


    }



    // 대출내역조회
    @GetMapping("/check/{userId}")
    public LogResponseDto getCheck(@PathVariable Long userId) {
        return libService.getCheck(userId);
    }

}
