package infrastructure.repositories;

import domain.models.Budget;
import domain.models.User;
import domain.repositories.BudgetRepository;

import java.util.List;

public class FileBudgetRepository
        implements BudgetRepository {

    @Override
    public void addBudget(
            User user,
            Budget budget) {

        user.getBudgets()
                .add(budget);
    }

    @Override
    public List<Budget> getAllBudgets(
            User user) {

        return user.getBudgets();
    }

    @Override
    public void removeBudget(
            User user,
            Budget budget) {

        user.getBudgets()
                .remove(budget);
    }
}