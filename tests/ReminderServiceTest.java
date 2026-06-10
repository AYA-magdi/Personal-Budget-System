package tests;

import domain.models.Reminder;
import domain.models.User;
import domain.repositories.ReminderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ReminderService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReminderServiceTest {

    private ReminderService service;
    private User user;

    @BeforeEach
    void setup() {

        service = new ReminderService(
                new FakeReminderRepository());

        user = new User(
                "Aya",
                "aya@test.com",
                "01012345678",
                "123456");
    }

    @Test
    void shouldAddReminder() {

        Reminder reminder = new Reminder(
                "Pay Rent",
                "2025-01-01",
                "10:00");

        service.addReminder(
                user,
                reminder);

        assertEquals(
                1,
                user.getReminders()
                        .size());
    }

    private static class FakeReminderRepository
            implements ReminderRepository {

        @Override
        public void save(
                User user,
                Reminder reminder) {
        }

        @Override
        public List<Reminder> findAll(
                User user) {

            return new ArrayList<>();
        }
    }
}