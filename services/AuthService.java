package services;

import domain.models.User;
import domain.repositories.UserRepository;
import validators.AuthValidator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class AuthService {

    private final UserRepository userRepository;

    public AuthService(
            UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User login(
            String email,
            String password) {

        AuthValidator.validateLogin(
                email,
                password);

        User user = userRepository.findByEmail(
                email);

        if (user == null) {
            throw new IllegalArgumentException(
                    "User not found.");
        }

        String hashedPassword = hashPassword(password);

        if (!user.getPassword()
                .equals(hashedPassword)) {

            throw new IllegalArgumentException(
                    "Invalid password.");
        }

        return user;
    }

    public void register(
            String name,
            String email,
            String phone,
            String password) {

        AuthValidator.validateRegistration(
                name,
                email,
                phone,
                password);

        if (userRepository.findByEmail(
                email) != null) {

            throw new IllegalArgumentException(
                    "Email already exists.");
        }

        List<User> users = userRepository.loadUsers();

        users.add(
                new User(
                        name,
                        email,
                        phone,
                        hashPassword(password)));

        userRepository.saveUsers(
                users);
    }

    public void resetPassword(
            String email,
            String newPassword) {

        User user = userRepository.findByEmail(
                email);

        if (user == null) {

            throw new IllegalArgumentException(
                    "User not found.");
        }

        user.setPassword(
                hashPassword(
                        newPassword));

        userRepository.updateUser(
                user);
    }

    private String hashPassword(
            String password) {

        try {

            MessageDigest md = MessageDigest.getInstance(
                    "SHA-256");

            byte[] bytes = md.digest(
                    password.getBytes(
                            StandardCharsets.UTF_8));

            StringBuilder builder = new StringBuilder();

            for (byte b : bytes) {

                builder.append(
                        String.format(
                                "%02x",
                                b));
            }

            return builder.toString();

        } catch (NoSuchAlgorithmException ex) {

            throw new RuntimeException(
                    ex);
        }
    }
}