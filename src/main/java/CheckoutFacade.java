package main.java;

public class CheckoutFacade {
    private Payment payment;

    public CheckoutFacade(Payment payment) {
        this.payment = payment;
    }

    public void process_payment(double amount , double discount_per, double cashback_per ) {
        if (cashback_per > 0){
            payment = new CashbackDecorator(cashback_per,payment);
        }
        if  (discount_per > 0){
            payment = new DiscountDecorator(discount_per,payment);
        }
        payment = new FraudDetectionDecorator(payment);

        System.out.println("---- Checkout Started ----");
        payment.pay(amount);
        sendReceipt(amount);
        sendNotification();
        System.out.println("---- Checkout Completed ----\n");
    }

    private void sendReceipt(double amount) {
        System.out.println("Receipt: Payment of $" + amount + " processed successfully.");
    }

    private void sendNotification() {
        System.out.println("Notification: Thank you for your purchase!");
    }
    public void process_payment() {
        this.process_payment(500, 10, 0);
    }
}


