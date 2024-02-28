package com.sparta.springlv2.service;

import com.sparta.springlv2.dto.*;
import com.sparta.springlv2.entity.Book;
import com.sparta.springlv2.repository.BookRepository;
import com.sparta.springlv2.repository.RentRepository;
import com.sparta.springlv2.repository.UserRepository;
import com.sparta.springlv2.entity.User;
import com.sparta.springlv2.entity.Rent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final RentRepository rentRepository;

    public LibService(BookRepository bookRepository, UserRepository userRepository, RentRepository rentRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.rentRepository = rentRepository;
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

    // 회원 등록
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = new User(userRequestDto);

        User saveUser = userRepository.save(user);

        UserResponseDto userResponseDto = new UserResponseDto(user);

        return userResponseDto;
    }

//    // 회원 조회
//    public List<UserResponseDto> getUser() {
//        return userRepository.findAll().stream().map(UserResponseDto::new).toList();
//    }

    // 선택 도서 대출



    // 대출 내역 조회
    public RentResponseDto getCheck(Long userId) {
        Rent log = findLog(userId);
        return new RentResponseDto(log);
    }

    private Rent findLog(Long userId) {
        return rentRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("선택한 회원의 대출 내역은 존재하지 않습니다.")
        );
    }
}

