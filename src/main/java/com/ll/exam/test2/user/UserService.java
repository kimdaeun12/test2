package com.ll.exam.test2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        this.userRepository.save(user);
        return user;
    }

}
