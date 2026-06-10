package tests;

import domain.models.Expense;
import domain.models.User;
import domain.repositories.ExpenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ExpenseService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseServiceTest {

    private ExpenseService service;
    private User user;

    @BeforeEach
    void setup() {

        service = new ExpenseService(
                new FakeExpenseRepository());

        user = new User(
                "Aya",
                "aya@test.com",
                "01012345678",
                "123456");
    }

    @Test
    void shouldAddExpense() {

        Expense expense = new Expense(
                "Food",
                100,
                "2025-01-01",
                "Cash");

        service.addExpense(
                user,
                expense);

        assertEquals(
                1,
                user.getExpenses()
                        .size());
    }

    private static class FakeExpenseRepository
            implements ExpenseRepository {

        @Override
        public void save(
                User user,
                Expense expense) {
        }

        @Override
        public List<Expense> findAll(
                User user) {

            return new ArrayList<>();
        }
    }
}