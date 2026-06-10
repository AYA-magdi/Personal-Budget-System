package services;

import domain.models.Income;
import domain.models.User;
import domain.repositories.IncomeRepository;

import java.util.List;

public class IncomeService {

    private final IncomeRepository repository;

    public IncomeService(
            IncomeRepository repository) {

        this.repository = repository;
    }

    public void addIncome(
            User user,
            Income income) {

        repository.addIncome(
                user,
                income);
    }

    public List<Income> getAllIncome(
            User user) {

        return repository.getAllIncomes(
                user);
    }

    public void removeIncome(
            User user,
            Income income) {

        repository.removeIncome(
                user,
                income);
    }

    public double getTotalIncome(
            User user) {

        return user.getIncomes()
                .stream()
                .mapToDouble(
                        Income::getAmount)
                .sum();
    }
}