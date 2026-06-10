package domain.models;

import java.io.Serializable;

public class Expense implements Serializable {

    private String category;
    private double amount;
    private String date;
    private String paymentMethod;

    public Expense(
            String category,
            double amount,
            String date,
            String paymentMethod) {

        this.category = category;
        this.amount = amount;
        this.date = date;
        this.paymentMethod = paymentMethod;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(
            String category) {

        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(
            double amount) {

        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(
            String date) {

        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(
            String paymentMethod) {

        this.paymentMethod = paymentMethod;
    }
}