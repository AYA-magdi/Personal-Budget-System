package tests;

import domain.models.Budget;
import domain.models.User;
import domain.repositories.BudgetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.BudgetService;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BudgetServiceTest {

    private BudgetService service;
    private User user;

    @BeforeEach
    void setup() {

        service = new BudgetService(
                new FakeBudgetRepository());

        user = new User(
                "Aya",
                "aya@test.com",
                "01012345678",
                "123456");
    }

    @Test
    void shouldAddBudget() {

        Budget budget = new Budget(
                "Food",
                2000);

        service.addBudget(
                user,
                budget);

        assertTrue(
                user.getBudgets()
                        .containsKey(
                                "Food"));
    }

    private static class FakeBudgetRepository
            implements BudgetRepository {

        @Override
        public void save(
                User user,
                Budget budget) {
        }

        @Override
        public HashMap<String, Double> findAll(
                User user) {

            return new HashMap<>();
        }
    }
}