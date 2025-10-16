package main.java.ui;

import java.util.*;
import main.java.model.Customer;
import main.java.payment.*;
import main.java.facade.CheckoutFacade;

public class ConsoleUI {
    private final Scanner sc = new Scanner(System.in);
    private Customer customer;

    public void start() {
        System.out.println("=== Multi-Payment Checkout System ===");
        initCustomer();

        while (true) {
            System.out.println("""
                \n===== MENU =====
                1️⃣ Make Payment
                2️⃣ Add Money to Card
                3️⃣ Add New Payment Method
                4️⃣ View Customer Info
                0️⃣ Exit
                """);

            System.out.print("Select option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> handlePayment();
                case 2 -> handleAddMoney();
                case 3 -> addPaymentMethod();
                case 4 -> showCustomerInfo();
                case 0 -> {
                    System.out.println("Goodbye, " + customer.getName() + "!");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void initCustomer() {
        System.out.print("Enter your name: ");
        sc.nextLine(); // clear buffer
        String name = sc.nextLine();

        customer = new Customer(name);
        addPaymentMethod();
    }

    private void addPaymentMethod() {
        System.out.println("""
            Choose type:
            1. Credit Card
            2. PayPal
            """);
        int type = sc.nextInt();
        sc.nextLine(); // clear buffer

        if (type == 1) {
            System.out.print("Enter card name: ");
            String cardName = sc.nextLine();
            System.out.print("Enter starting balance: ");
            double balance = sc.nextDouble();
            customer.addPaymentMethod(new CreditCardPayment(cardName, balance));
        } else {
            System.out.print("Enter PayPal email: ");
            String email = sc.nextLine();
            System.out.print("Enter starting balance: ");
            double balance = sc.nextDouble();
            customer.addPaymentMethod(new PayPalPayment(email, balance));
        }
    }

    private Payment choosePaymentMethod() {
        if (customer.getPaymentMethods().isEmpty()) {
            System.out.println("No cards found, please add one first.");
            addPaymentMethod();
        }

        System.out.println("Choose payment method:");
        customer.showPaymentMethods();
        int idx = sc.nextInt() - 1;

        if (idx < 0 || idx >= customer.getPaymentMethods().size()) {
            System.out.println("Invalid choice, using first card.");
            idx = 0;
        }
        return customer.getPaymentMethods().get(idx);
    }

    private void handlePayment() {
        Payment method = choosePaymentMethod();
        CheckoutFacade checkout = new CheckoutFacade(method);

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter discount %: ");
        double discount = sc.nextDouble();

        System.out.print("Enter cashback %: ");
        double cashback = sc.nextDouble();

        checkout.processPayment(amount, discount, cashback);
    }

    private void handleAddMoney() {
        Payment method = choosePaymentMethod();
        System.out.print("Enter amount to add: ");
        double amount = sc.nextDouble();
        method.addMoney(amount);
    }

    private void showCustomerInfo() {
        System.out.println("\n👤 " + customer);
        customer.showPaymentMethods();
    }
}
