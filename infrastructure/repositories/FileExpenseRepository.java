package infrastructure.repositories;

import domain.models.Expense;
import domain.models.User;
import domain.repositories.ExpenseRepository;

import java.util.List;

public class FileExpenseRepository
        implements ExpenseRepository {

    @Override
    public void addExpense(
            User user,
            Expense expense) {

        user.getExpenses()
                .add(expense);
    }

    @Override
    public List<Expense> getAllExpenses(
            User user) {

        return user.getExpenses();
    }

    @Override
    public void removeExpense(
            User user,
            Expense expense) {

        user.getExpenses()
                .remove(expense);
    }
}