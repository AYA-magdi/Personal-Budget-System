package tests;

import domain.models.User;
import domain.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.AuthService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    private AuthService authService;

    @BeforeEach
    void setUp() {

        UserRepository repository = new FakeUserRepository();

        authService = new AuthService(repository);
    }

    @Test
    void shouldRegisterUser() {

        User user = authService.register(
                "Aya",
                "aya@test.com",
                "01012345678",
                "123456");

        assertNotNull(user);
        assertEquals(
                "aya@test.com",
                user.getEmail());
    }

    @Test
    void shouldLoginSuccessfully() {

        authService.register(
                "Aya",
                "aya@test.com",
                "01012345678",
                "123456");

        User user = authService.login(
                "aya@test.com",
                "123456");

        assertNotNull(user);
    }

    @Test
    void shouldThrowExceptionForWrongPassword() {

        authService.register(
                "Aya",
                "aya@test.com",
                "01012345678",
                "123456");

        assertThrows(
                RuntimeException.class,
                () -> authService.login(
                        "aya@test.com",
                        "wrong"));
    }

    private static class FakeUserRepository
            implements UserRepository {

        private final List<User> users = new ArrayList<>();

        @Override
        public void save(User user) {
            users.add(user);
        }

        @Override
        public User findByEmail(String email) {

            return users.stream()
                    .filter(u -> u.getEmail()
                            .equals(email))
                    .findFirst()
                    .orElse(null);
        }

        @Override
        public List<User> findAll() {
            return users;
        }
    }
}