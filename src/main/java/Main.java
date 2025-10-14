package main.java;

public class Main {
    public static void main(String[] args) {
        Payment card = new CreditCardPayment();
        CheckoutFacade checkout = new CheckoutFacade(card);

        checkout.process_payment();
    }
}
