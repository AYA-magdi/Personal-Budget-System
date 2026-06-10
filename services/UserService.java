package services;

import domain.models.User;
import domain.repositories.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(
            UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {

        return userRepository.loadUsers();
    }

    public User getUserByEmail(
            String email) {

        return userRepository.findByEmail(
                email);
    }

    public void updateUser(
            User user) {

        userRepository.updateUser(
                user);
    }
}