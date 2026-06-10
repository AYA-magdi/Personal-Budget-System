package infrastructure.repositories;

import domain.models.User;
import domain.repositories.UserRepository;
import infrastructure.serialization.SerializationManager;

import java.util.ArrayList;
import java.util.List;

public class FileUserRepository
        implements UserRepository {

    private static final String FILE_NAME = "users.ser";

    @Override
    public void saveUsers(
            List<User> users) {

        SerializationManager.save(
                users,
                FILE_NAME);
    }

    @Override
    public List<User> loadUsers() {

        Object data = SerializationManager.load(
                FILE_NAME);

        if (data == null) {
            return new ArrayList<>();
        }

        return (List<User>) data;
    }

    @Override
    public User findByEmail(
            String email) {

        for (User user : loadUsers()) {

            if (user.getEmail()
                    .equalsIgnoreCase(email)) {

                return user;
            }
        }

        return null;
    }

    @Override
    public void updateUser(
            User updatedUser) {

        List<User> users = loadUsers();

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i)
                    .getEmail()
                    .equalsIgnoreCase(
                            updatedUser.getEmail())) {

                users.set(
                        i,
                        updatedUser);

                break;
            }
        }

        saveUsers(users);
    }
}