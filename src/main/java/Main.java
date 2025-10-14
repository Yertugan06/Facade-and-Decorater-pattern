package main.java;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Payment card1 = new CreditCardPayment();
        CheckoutFacade checkout = new CheckoutFacade(card1);

        checkout.process_payment();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter discount percentage: ");
        double discount_per = sc.nextDouble();

        System.out.print("Enter cashback percentage: ");
        double cashback_per = sc.nextDouble();

        Payment card2 = new PayPalPayment();
        CheckoutFacade checkout2 = new CheckoutFacade(card2);
        checkout2.process_payment(amount, discount_per, cashback_per);
    }
}
