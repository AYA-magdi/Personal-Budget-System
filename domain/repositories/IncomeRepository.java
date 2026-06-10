package domain.repositories;

import domain.models.Income;
import domain.models.User;

import java.util.List;

public interface IncomeRepository {

    void addIncome(
            User user,
            Income income);

    List<Income> getAllIncomes(
            User user);

    void removeIncome(
            User user,
            Income income);
}