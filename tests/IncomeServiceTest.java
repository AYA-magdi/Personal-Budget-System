package tests;

import domain.models.Income;
import domain.models.User;
import domain.repositories.IncomeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.IncomeService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IncomeServiceTest {

    private IncomeService service;
    private User user;

    @BeforeEach
    void setup() {

        service = new IncomeService(
                new FakeIncomeRepository());

        user = new User(
                "Aya",
                "aya@test.com",
                "01012345678",
                "123456");
    }

    @Test
    void shouldAddIncome() {

        Income income = new Income(
                "Salary",
                5000);

        service.addIncome(
                user,
                income);

        assertEquals(
                1,
                user.getIncomeEntries()
                        .size());
    }

    private static class FakeIncomeRepository
            implements IncomeRepository {

        @Override
        public void save(
                User user,
                Income income) {
        }

        @Override
        public List<Income> findAll(
                User user) {

            return new ArrayList<>();
        }
    }
}