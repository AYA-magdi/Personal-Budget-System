package services;

import domain.models.Reminder;
import domain.models.User;
import domain.repositories.ReminderRepository;

import java.util.List;

public class ReminderService {

    private final ReminderRepository repository;

    public ReminderService(
            ReminderRepository repository) {

        this.repository = repository;
    }

    public void addReminder(
            User user,
            Reminder reminder) {

        repository.addReminder(
                user,
                reminder);
    }

    public List<Reminder> getAllReminders(
            User user) {

        return repository.getAllReminders(
                user);
    }

    public void removeReminder(
            User user,
            Reminder reminder) {

        repository.removeReminder(
                user,
                reminder);
    }
}