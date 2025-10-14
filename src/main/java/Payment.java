package main.java;

public interface Payment {
    void pay(double amount);
    void add_cashback(double amount);
    void add_money(double amount);
}
