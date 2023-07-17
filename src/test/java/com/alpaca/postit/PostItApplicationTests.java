package com.alpaca.postit;

import com.alpaca.postit.user.User;
import com.alpaca.postit.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostItApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void findUserTest() {
        User user = new User("test_id", "test_password", "test_name", "test_email");
        userRepository.save(user);
        Optional<User> testUser = userRepository.findById("test_id");
        System.out.println("testUser" + testUser);
        Assertions.assertTrue(testUser.isPresent());
    }
}
