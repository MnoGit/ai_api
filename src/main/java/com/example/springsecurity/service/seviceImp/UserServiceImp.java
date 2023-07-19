package com.example.springsecurity.service.seviceImp;

import com.example.springsecurity.model.entity.UserInfo;
import com.example.springsecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo =userRepository.getUserByUserName(username);
        System.out.println(userInfo);

        if (userInfo ==null){
            throw new UsernameNotFoundException("user not found");

        }
        return userInfo;

    }

}
