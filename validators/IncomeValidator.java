package validators;

import domain.models.Income;

public class IncomeValidator {

    public static void validate(
            Income income) {

        if (income == null) {

            throw new IllegalArgumentException(
                    "Income cannot be null.");
        }

        if (income.getSource() == null ||
                income.getSource().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Income source is required.");
        }

        if (income.getAmount() <= 0) {

            throw new IllegalArgumentException(
                    "Income amount must be greater than zero.");
        }
    }
}