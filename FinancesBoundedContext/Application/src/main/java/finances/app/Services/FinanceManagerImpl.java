package finances.app.Services;

import finances.app.Services.Interfaces.FinanceManager;
import finances.domain.AccountAggregate.Repository.AccountRepository;
import finances.domain.TransactionAggregate.Factory.TransactionFactory;
import finances.domain.TransactionAggregate.Transaction;
import finances.domain.Services.ClientOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinanceManagerImpl implements FinanceManager {

    private AccountRepository accountRepository;
    private TransactionFactory transactionFactory;
    private ClientOrderRepository clientOrderRepository;

    @Autowired
    public FinanceManagerImpl(AccountRepository accountRepository, TransactionFactory transactionFactory,
                              ClientOrderRepository clientOrderRepository) {
        this.accountRepository = accountRepository;
        this.transactionFactory = transactionFactory;
        this.clientOrderRepository = clientOrderRepository;
    }



    @Override
    public void paid(int id) {
        Transaction transaction = transactionFactory.createTransaction(clientOrderRepository.getOrder(id));
        accountRepository.getAccount().addToBalance(transaction.getOrder().getPrice());
    }
}
