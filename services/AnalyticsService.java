package services;

import domain.models.User;

public class AnalyticsService {

    public double calculateBalance(
            User user) {

        double income = user.getIncomes()
                .stream()
                .mapToDouble(
                        i -> i.getAmount())
                .sum();

        double expenses = user.getExpenses()
                .stream()
                .mapToDouble(
                        e -> e.getAmount())
                .sum();

        return income - expenses;
    }

    public double calculateSavingsRate(
            User user) {

        double income = user.getIncomes()
                .stream()
                .mapToDouble(
                        i -> i.getAmount())
                .sum();

        double expenses = user.getExpenses()
                .stream()
                .mapToDouble(
                        e -> e.getAmount())
                .sum();

        if (income == 0) {
            return 0;
        }

        return ((income - expenses)
                / income) * 100;
    }
}