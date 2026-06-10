package domain.repositories;

import domain.models.Budget;
import domain.models.User;

import java.util.List;

public interface BudgetRepository {

    void addBudget(
            User user,
            Budget budget);

    List<Budget> getAllBudgets(
            User user);

    void removeBudget(
            User user,
            Budget budget);
}