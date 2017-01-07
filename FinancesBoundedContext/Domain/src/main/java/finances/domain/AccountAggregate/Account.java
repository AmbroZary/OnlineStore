package finances.domain.AccountAggregate;


import common.Interfaces.Entity;

public class Account extends Entity{

    private double balance;

    public Account() {
        this.balance = 0;
    }

    public Account(int id) {
        super(id);
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void addToBalance(double amount){
        balance += amount;
    }

}
