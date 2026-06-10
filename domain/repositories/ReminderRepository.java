package domain.repositories;

import domain.models.Reminder;
import domain.models.User;

import java.util.List;

public interface ReminderRepository {

    void addReminder(
            User user,
            Reminder reminder);

    List<Reminder> getAllReminders(
            User user);

    void removeReminder(
            User user,
            Reminder reminder);
}