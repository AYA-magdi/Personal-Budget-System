package validators;

import domain.models.Reminder;

public class ReminderValidator {

    public static void validate(
            Reminder reminder) {

        if (reminder == null) {

            throw new IllegalArgumentException(
                    "Reminder cannot be null.");
        }

        if (reminder.getTitle() == null ||
                reminder.getTitle().length() < 3 ||
                reminder.getTitle().length() > 50) {

            throw new IllegalArgumentException(
                    "Reminder title must be between 3 and 50 characters.");
        }

        validateDate(
                reminder.getDate());

        validateTime(
                reminder.getTime());
    }

    private static void validateDate(
            String date) {

        if (!date.matches(
                "\\d{4}-\\d{2}-\\d{2}")) {

            throw new IllegalArgumentException(
                    "Date must be in YYYY-MM-DD format.");
        }
    }

    private static void validateTime(
            String time) {

        if (!time.matches(
                "^([01]\\d|2[0-3]):([0-5]\\d)$")) {

            throw new IllegalArgumentException(
                    "Time must be in HH:MM format.");
        }
    }
}