package main.java;

public class PayPalPayment implements Payment {
    private double asset;
    private double cashback;
    public PayPalPayment(double asset, double cashback) {
        this.asset = asset;
        this.cashback = cashback;
    }

    public PayPalPayment() {
        this(50,5000);
    }
    @Override
    public void pay(double amount) {
        if (asset + cashback >= amount){
            System.out.println("Payment Successful using PayPal - amount: " + amount);
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
            System.out.println("Payment Unsuccessful using PayPal - amount: " + amount);
        }

    }

    @Override
    public void add_cashback(double amount) {
        cashback += amount;
    }
    @Override
    public void add_money(double amount) {
        asset += amount;
    }


}
