package com.cafe24.server;
import com.cafe24.server.domain.user.User;
import com.cafe24.server.repository.UserRepository;
import com.cafe24.server.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
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

    @Test
    void testRegisterUser_Success() {
        User user = userService.registerUser("testuser", "password123", "test@example.com");
        Assertions.assertNotNull(user.getId());
        Assertions.assertEquals("testuser", user.getUsername());
    }

    @Test
    void testRegisterUser_DuplicateUsername() {
        userService.registerUser("duplicate", "pass", "dup1@example.com");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.registerUser("duplicate", "pass2", "dup2@example.com");
        });
    }

    @Test
    void testRegisterUser_DuplicateEmail() {
        userService.registerUser("unique1", "pass", "same@example.com");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.registerUser("unique2", "pass2", "same@example.com");
        });
    }
}