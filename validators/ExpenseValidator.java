package validators;

import domain.models.Expense;

public class ExpenseValidator {

    public static void validate(
            Expense expense) {

        if (expense == null) {

            throw new IllegalArgumentException(
                    "Expense cannot be null.");
        }

        if (expense.getCategory() == null ||
                expense.getCategory().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Category is required.");
        }

        if (expense.getAmount() <= 0) {

            throw new IllegalArgumentException(
                    "Amount must be greater than zero.");
        }

        if (expense.getDate() == null ||
                expense.getDate().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Date is required.");
        }

        if (expense.getPaymentMethod() == null ||
                expense.getPaymentMethod().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Payment method is required.");
        }
    }
}