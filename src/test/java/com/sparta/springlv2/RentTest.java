//package com.sparta.springlv2;
//
//import com.sparta.springlv2.entity.Rent;
//import com.sparta.springlv2.repository.RentRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@SpringBootTest
//public class RentTest {
//
//    @Autowired
//    RentRepository rentRepository;
//
//    @Test
//    @Transactional
//    @Rollback(value = false) // 테스트 코드에서 @Transactional 를 사용하면 테스트가 완료된 후 롤백하기 때문에 false 옵션 추가
//    @DisplayName("대출 성공")
//    void test1() {
//        Rent rent = new Rent();
//
//        rent.setBookId(1L);
//        rent.setUserId(3L);
//
////        Rent rentBook = rentRepository.findById(rent.getBookId()).orElseThrow(() ->
////                new NullPointerException("없음"));
//
//        List<Rent> rentBook = rentRepository.findAllByBookId(rent.getBookId());
//        for (Rent rented : rentBook) {
//            if (!rented.isReturned()) {
//                return;
//            }
//        }
//
//        Rent saveRent = rentRepository.save(rent);;
//    }
//
//    @Test
//    @Transactional
//    @Rollback(value = false) // 테스트 코드에서 @Transactional 를 사용하면 테스트가 완료된 후 롤백하기 때문에 false 옵션 추가
//    @DisplayName("수정")
//    void test2() {
//        Rent rentBook = rentRepository.findById(1L).orElseThrow(() ->
//                new NullPointerException("없음"));
//
//        rentBook.setReturned(true);
//    }
//}
