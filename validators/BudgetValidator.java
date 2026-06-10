package validators;

import domain.models.Budget;

public class BudgetValidator {

    public static void validate(
            Budget budget) {

        if (budget == null) {

            throw new IllegalArgumentException(
                    "Budget cannot be null.");
        }

        if (budget.getCategory() == null ||
                budget.getCategory().trim().length() < 3) {

            throw new IllegalArgumentException(
                    "Category must contain at least 3 characters.");
        }

        if (budget.getAmount() <= 0) {

            throw new IllegalArgumentException(
                    "Budget amount must be greater than zero.");
        }
    }
}