package dk.dtu.CDIOg18.dicegame;

public class Account {

    private double balance = 0;

    public Account() {

    }

    public Account(double amount) {
        balance = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void giveMoney(double amount) {
        balance += amount;
    }

    public boolean takeMoney(double amount) {
        if(this.balance - amount <= 0) {
            return false;
        }
        balance -= amount;
        return true;
    }
 }
