package com.sparta.springlv2.service;

import com.sparta.springlv2.dto.*;
import com.sparta.springlv2.entity.Book;
import com.sparta.springlv2.repository.BookRepository;
import com.sparta.springlv2.repository.RentRepository;
import com.sparta.springlv2.repository.UserRepository;
import com.sparta.springlv2.entity.User;
import com.sparta.springlv2.entity.Rent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public RentResponseDto rentBook(RentRequestDto rentRequestDto) {
        Rent rent = new Rent(rentRequestDto);

        // 회원이 대출중인지 여부 판단
        List<Rent> users = rentRepository.findAllByUserId(rent.getUserId());
        for (Rent user : users) {
            if (!user.isReturned()) {
                return null;
            }
        }
        // 책이 대출중인지 여부 판단
        List<Rent> rentedBook = rentRepository.findAllByBookId(rent.getBookId());
        for (Rent rented : rentedBook) {
            if (!rented.isReturned()) {
                return null;
            }
        }

        Rent saveRent = rentRepository.save(rent);;

        RentResponseDto rentResponseDto = new RentResponseDto(rent);

        return rentResponseDto;
    }

    // 선택 도서 반납
    public RentResponseDto returnBook(RentRequestDto requestDto) {
        Rent rent = new Rent(requestDto);

        List<Rent> rentedBook = rentRepository.findAllByUserIdAndBookId(rent.getUserId(), rent.getBookId());
        for (Rent rented : rentedBook) {
            if (!rented.isReturned()) {
                rented.setReturned(true);
                rented.update(requestDto);
                break;
            }
        }

        return new RentResponseDto(rent);
    }

    // 대출 내역 조회
    public List<LogResponseDto> getCheck(Long userId) {
        List<LogResponseDto> logResponseDtoList = new ArrayList<>();

        List<Rent> logs = rentRepository.findAllByUserIdOrderByCreatedAt(userId);
        for (Rent log :logs) {
            User user = userRepository.findById(log.getUserId()).orElseThrow();
            Book book = bookRepository.findById(log.getBookId()).orElseThrow();
            logResponseDtoList.add(new LogResponseDto(log, user, book));
        }

        return logResponseDtoList;
    }
}

