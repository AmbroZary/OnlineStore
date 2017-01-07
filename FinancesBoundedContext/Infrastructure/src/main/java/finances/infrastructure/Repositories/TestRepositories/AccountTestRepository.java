package finances.infrastructure.Repositories.TestRepositories;

import finances.domain.AccountAggregate.Account;
import finances.domain.AccountAggregate.Repository.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

// @Component
public class AccountTestRepository extends AccountRepository {
    private LinkedList<Account> list;

    public AccountTestRepository() {
        this.list = new LinkedList<>();
    }

    private void updateAccount() {
        list.pop();
        list.add(account);
    }

    @Override
    public void addBalance(double amount) {
        account.addToBalance(amount);
        updateAccount();
    }

    @Override
    protected Account findAccount() {
        return list.getFirst();
    }

    @Override
    protected Account createAccount() {
        Account account = new Account();
        list.add(account);
        return account;
    }
}
