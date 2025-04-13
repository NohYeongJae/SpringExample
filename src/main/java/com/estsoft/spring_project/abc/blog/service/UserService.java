package com.estsoft.spring_project.abc.blog.service;

import com.estsoft.spring_project.abc.blog.domain.User;
import com.estsoft.spring_project.abc.blog.dto.AddUserRequest;
import com.estsoft.spring_project.abc.blog.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public void signup(AddUserRequest request) {
        userRepository.save(
                new User(request.getEmail(), encoder.encode(request.getPassword()))
        );
    }
}
