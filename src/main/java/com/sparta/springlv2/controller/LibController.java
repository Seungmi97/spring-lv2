package com.sparta.springlv2.controller;

import com.sparta.springlv2.dto.UserRequestDto;
import com.sparta.springlv2.dto.UserResponseDto;
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
}


//
//    @GetMapping("/post")
//    public List<PostResponseDto> getPosts() {
//        return postService.getPosts();
//    }
//
//    @GetMapping("/post/{id}")
//    public PostResponseDto getPostById(@PathVariable Long id) {
//        return postService.getPostById(id);
//    }
//
//    @PutMapping("/post/{id}")
//    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
//        return postService.updatePost(id, requestDto);
//    }
//
//    @DeleteMapping("/post/{id}")
//    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
//        return postService.deletePost(id, requestDto);
//    }
//}