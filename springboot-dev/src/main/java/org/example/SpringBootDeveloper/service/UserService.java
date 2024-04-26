package org.example.SpringBootDeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.SpringBootDeveloper.domain.User;
import org.example.SpringBootDeveloper.dto.AddUserRequest;
import org.example.SpringBootDeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long save(AddUserRequest dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return userRepository.save(User.builder()
                .email(dto.getEmail())
                //1. 패스워드 암호화
                .password(encoder.encode(dto.getPassword()))
                .build()).getId();
    }

    //메서드 추가
    public User findById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("Unexcepted user"));
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Unexcepted user"));
    }
}
