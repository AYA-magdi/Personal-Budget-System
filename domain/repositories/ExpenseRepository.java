package domain.repositories;

import domain.models.Expense;
import domain.models.User;

import java.util.List;

public interface ExpenseRepository {

    void addExpense(
            User user,
            Expense expense);

    List<Expense> getAllExpenses(
            User user);

    void removeExpense(
            User user,
            Expense expense);
}