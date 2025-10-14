package main.java;

public class DiscountDecorator implements Payment {
    private final Payment payment;
    private final double discount_per;

    public DiscountDecorator(double discount_per,  Payment payment) {
        this.discount_per = discount_per;
        this.payment = payment;
    }

    @Override
    public void pay(double amount) {
        double discounted = amount * (1 - discount_per / 100);
        System.out.println("Applied " + discount_per + "% discount. Final: " + discounted + "$");
        payment.pay(discounted);
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
