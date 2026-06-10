package validators;

import domain.models.User;

public class UserValidator {

    public static void validate(
            User user) {

        if (user == null) {

            throw new IllegalArgumentException(
                    "User cannot be null.");
        }

        if (user.getName() == null ||
                user.getName().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "User name is required.");
        }

        if (user.getEmail() == null ||
                user.getEmail().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Email is required.");
        }
    }
}