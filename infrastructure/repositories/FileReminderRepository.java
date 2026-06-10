package infrastructure.repositories;

import domain.models.Reminder;
import domain.models.User;
import domain.repositories.ReminderRepository;

import java.util.List;

public class FileReminderRepository
        implements ReminderRepository {

    @Override
    public void addReminder(
            User user,
            Reminder reminder) {

        user.getReminders()
                .add(reminder);
    }

    @Override
    public List<Reminder> getAllReminders(
            User user) {

        return user.getReminders();
    }

    @Override
    public void removeReminder(
            User user,
            Reminder reminder) {

        user.getReminders()
                .remove(reminder);
    }
}