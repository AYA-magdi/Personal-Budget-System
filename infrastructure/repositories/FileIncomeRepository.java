package infrastructure.repositories;

import domain.models.Income;
import domain.models.User;
import domain.repositories.IncomeRepository;

import java.util.List;

public class FileIncomeRepository
        implements IncomeRepository {

    @Override
    public void addIncome(
            User user,
            Income income) {

        user.getIncomes()
                .add(income);
    }

    @Override
    public List<Income> getAllIncomes(
            User user) {

        return user.getIncomes();
    }

    @Override
    public void removeIncome(
            User user,
            Income income) {

        user.getIncomes()
                .remove(income);
    }
}