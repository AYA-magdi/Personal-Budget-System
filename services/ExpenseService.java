package services;

import domain.models.Expense;
import domain.models.User;
import domain.repositories.ExpenseRepository;

import java.util.List;

public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(
            ExpenseRepository repository) {

        this.repository = repository;
    }

    public void addExpense(
            User user,
            Expense expense) {

        repository.addExpense(
                user,
                expense);
    }

    public List<Expense> getAllExpenses(
            User user) {

        return repository.getAllExpenses(
                user);
    }

    public void removeExpense(
            User user,
            Expense expense) {

        repository.removeExpense(
                user,
                expense);
    }

    public double getTotalExpenses(
            User user) {

        return user.getExpenses()
                .stream()
                .mapToDouble(
                        Expense::getAmount)
                .sum();
    }
}