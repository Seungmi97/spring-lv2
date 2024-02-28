package com.sparta.springlv2.controller;

import com.sparta.springlv2.dto.BookRequestDto;
import com.sparta.springlv2.dto.BookResponseDto;
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
}
