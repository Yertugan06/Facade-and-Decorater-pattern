package main.java;

public class CheckoutFacade {
    private Payment payment;

    public CheckoutFacade(Payment payment) {
        this.payment = payment;
    }

    public void process_payment(double amount , double discount_per, double cashback_per ) {
        payment = new CashbackDecorator(cashback_per,payment);
        payment = new DiscountDecorator(discount_per,payment);
        payment = new FraudDetectionDecorator(payment);

        System.out.println("---- Checkout Started ----");
        payment.pay(amount);
        System.out.println("---- Checkout Completed ----\n");
    }
    public void process_payment() {
        this.process_payment(500, 10, 5);
    }
}
