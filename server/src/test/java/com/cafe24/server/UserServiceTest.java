package com.cafe24.server;
import com.cafe24.server.domain.user.User;
import com.cafe24.server.repository.UserRepository;
import com.cafe24.server.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void 회원가입_로그인_테스트() {
        User user = userService.register("testUser", "test@example.com", "password123");

        assertThat(userRepository.findByUsername("testUser")).isPresent();

        boolean loginSuccess = userService.login("testUser", "password123");
        boolean loginFail = userService.login("testUser", "wrongPassword");

        assertThat(loginSuccess).isTrue();
        assertThat(loginFail).isFalse();
    }

    @Test
    void 로그인_실패_5회_계정잠금() {
        userService.register("lockUser", "lock@example.com", "secure123");

        for (int i = 0; i < 5; i++) {
            userService.login("lockUser", "wrongPass");
        }

        User lockedUser = userRepository.findByUsername("lockUser").orElseThrow();
        assertThat(lockedUser.isLocked()).isTrue();
    }
}