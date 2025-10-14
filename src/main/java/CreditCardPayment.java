package main.java;

public class CreditCardPayment implements Payment {
    private double asset;
    private double cashback;
    public CreditCardPayment(double cashback, double asset) {
        this.cashback = cashback;
        this.asset = asset;
    }
    public CreditCardPayment() {
        this(50,5000);
    }
    @Override
    public void pay(double amount) {
        if (asset + cashback >= amount){
            System.out.println("Payment Successful using Credit Card - amount: " + amount);
            if (amount > cashback){
                amount -= cashback;
                cashback = 0;
                asset -= amount;
            }
            else {
                cashback -= amount;
            }
        }
        else {
            System.out.println("Payment Unsuccessful using Credit Card - amount: " + amount);
        }

    }

    @Override
    public void add_cashback(double amount) {
        cashback += amount;
        System.out.println("Added into cashback " + amount);
    }

    @Override
    public void add_money(double amount) {
        asset += amount;
        System.out.println("Added into asset" + amount);
    }
}
