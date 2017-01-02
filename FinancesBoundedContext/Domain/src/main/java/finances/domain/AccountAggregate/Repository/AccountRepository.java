package finances.domain.AccountAggregate.Repository;

import finances.domain.AccountAggregate.Account;

public abstract class AccountRepository {

    protected Account account;

    public Account getAccount(){
        if(account == null){
            account = findAccount();
        }
        if(account == null){
            account = createAccount();
        }
        return account;
    }

    public abstract void addBalance(double amount);
    protected abstract Account findAccount();
    protected abstract Account createAccount();
}
