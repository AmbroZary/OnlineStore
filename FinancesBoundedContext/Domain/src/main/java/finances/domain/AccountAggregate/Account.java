package finances.domain.AccountAggregate;


public class Account{

    private double balance;

    public Account() {
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
