package main.java;

public class FraudDetectionDecorator implements Payment{
    private final Payment payment;

    public FraudDetectionDecorator(Payment payment) {
        this.payment = payment;
    }

    private boolean is_safe(double amount) {
        if (amount > 100000 || amount <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public void pay(double amount) {
        if (is_safe(amount)) {
            System.out.println("Suspicious payment was not detected");
            payment.pay(amount);
        }
        else {
            System.out.println("Suspicious payment detected:" + amount + "$");
        }
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
