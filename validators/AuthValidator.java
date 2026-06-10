package validators;

public class AuthValidator {

    public static void validateLogin(
            String email,
            String password) {

        if (email == null ||
                email.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Email is required.");
        }

        if (password == null ||
                password.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Password is required.");
        }
    }

    public static void validateRegistration(
            String name,
            String email,
            String phone,
            String password) {

        if (name == null ||
                name.trim().length() < 3) {

            throw new IllegalArgumentException(
                    "Name must contain at least 3 characters.");
        }

        if (!email.matches(
                "^[A-Za-z0-9+_.-]+@(.+)$")) {

            throw new IllegalArgumentException(
                    "Invalid email format.");
        }

        if (!phone.matches(
                "\\d{11}")) {

            throw new IllegalArgumentException(
                    "Phone number must contain 11 digits.");
        }

        if (password.length() < 6) {

            throw new IllegalArgumentException(
                    "Password must contain at least 6 characters.");
        }
    }
}