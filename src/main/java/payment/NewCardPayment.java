package main.java.payment;

public class NewCardPayment implements Payment {
    private final String cardName;
    private double balance;

    public NewCardPayment(String cardName, double balance) {
        this.cardName = cardName;
        this.balance = balance;
    }

    @Override
    public void pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.printf("Paid $%.2f via [%s].%n", amount, cardName);
        } else {
            System.out.println("nsufficient balance on " + cardName + "!");
        }
    }

    @Override
    public void addCashback(double amount) {
        balance += amount;
        System.out.printf("Cashback $%.2f added to card [%s]. New balance: $%.2f%n", amount, cardName, balance);
    }

    @Override
    public void addMoney(double amount) {
        balance += amount;
        System.out.printf("Added $%.2f to [%s]. Balance: $%.2f%n", amount, cardName, balance);
    }

    @Override
    public String toString() {
        return "[" + cardName + "] - $" + balance;
    }
}
