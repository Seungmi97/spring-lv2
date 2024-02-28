package com.sparta.springlv2.service;

import com.sparta.springlv2.dto.BookRequestDto;
import com.sparta.springlv2.dto.BookResponseDto;
import com.sparta.springlv2.entity.Book;
import com.sparta.springlv2.repository.BookRepository;
import com.sparta.springlv2.repository.LogRepository;
import com.sparta.springlv2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final LogRepository logRepository;

    public LibService(BookRepository bookRepository, UserRepository userRepository, LogRepository logRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.logRepository = logRepository;
    }

    public BookResponseDto registerBook(BookRequestDto requestDto) {
        Book book = new Book(requestDto);

        Book saveBook = bookRepository.save(book);

        BookResponseDto bookResponseDto = new BookResponseDto(book);

        return bookResponseDto;
    }

    public List<BookResponseDto> getBooks() {
        return bookRepository.findAllByOrderByCreatedAt().stream().map(BookResponseDto::new).toList();
    }

    public BookResponseDto getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new NullPointerException("선택한 도서 정보가 없습니다."));

        BookResponseDto bookResponseDto = new BookResponseDto(book);

        return bookResponseDto;
    }
}
