package com.example.springsecurity.controller;

import com.example.springsecurity.service.seviceImp.TestServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer")
public class TestController {
    private final TestServiceImpl testService;
    @GetMapping("/getall")
    public List<?> test(){
        return testService.test();
    }

}
