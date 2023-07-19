package com.example.springsecurity.service.seviceImp;

import com.example.springsecurity.repository.UserRepository;
import com.example.springsecurity.service.TestService;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final UserRepository userRepository;
    @Override
    public List<?> test() {
        return userRepository.test();
    }
}
