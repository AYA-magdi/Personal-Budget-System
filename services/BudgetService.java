package services;

import domain.models.Budget;
import domain.models.Expense;
import domain.models.User;
import domain.repositories.BudgetRepository;

public class BudgetService {

    private final BudgetRepository repository;

    public BudgetService(
            BudgetRepository repository) {

        this.repository = repository;
    }

    public void addBudget(
            User user,
            Budget budget) {

        repository.addBudget(
                user,
                budget);
    }

    public String analyzeBudget(
            User user) {

        StringBuilder report = new StringBuilder();

        report.append(
                "Budget Analysis\n\n");

        for (Budget budget : user.getBudgets()) {

            double spent = 0;

            for (Expense expense : user.getExpenses()) {

                if (expense.getCategory()
                        .equalsIgnoreCase(
                                budget.getCategory())) {

                    spent += expense.getAmount();
                }
            }

            report.append(
                    "Category: ")
                    .append(
                            budget.getCategory())
                    .append("\n");

            report.append(
                    "Budget: ")
                    .append(
                            budget.getAmount())
                    .append("\n");

            report.append(
                    "Spent: ")
                    .append(
                            spent)
                    .append("\n");

            report.append(
                    "Remaining: ")
                    .append(
                            budget.getAmount()
                                    - spent)
                    .append("\n\n");
        }

        return report.toString();
    }
}