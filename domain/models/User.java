package domain.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    private String name;
    private String email;
    private String phone;
    private String password;

    private List<Income> incomes;
    private List<Expense> expenses;
    private List<Budget> budgets;
    private List<Reminder> reminders;

    public User(
            String name,
            String email,
            String phone,
            String password) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;

        this.incomes = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.budgets = new ArrayList<>();
        this.reminders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public List<Reminder> getReminders() {
        return reminders;
    }
}