package main.java;

public class CashbackDecorator implements Payment{
    private double cashback_per;
    private Payment payment;

    public CashbackDecorator(double cashback_per, Payment payment) {
        this.cashback_per = cashback_per;
        this.payment = payment;
    }

    @Override
    public void pay(double amount) {
        payment.pay(amount);
        double cashbackAmount = amount * cashback_per / 100;
        System.out.println("Cashback Earned:" + cashbackAmount + "$");
        payment.add_cashback(cashbackAmount);
    }

    @Override
    public void add_cashback(double amount) {
        payment.add_cashback(amount);
    }

    @Override
    public void add_money(double amount) {
        payment.add_money(amount);
    }
}
