package domain.repositories;

import domain.models.User;

import java.util.List;

public interface UserRepository {

    void saveUsers(
            List<User> users);

    List<User> loadUsers();

    User findByEmail(
            String email);

    void updateUser(
            User user);
}