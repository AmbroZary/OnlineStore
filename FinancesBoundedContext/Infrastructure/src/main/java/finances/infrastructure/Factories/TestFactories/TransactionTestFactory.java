package finances.infrastructure.Factories.TestFactories;

import finances.domain.Services.FinancesClientTranslator;
import finances.domain.TransactionAggregate.Factory.TransactionFactory;
import finances.domain.TransactionAggregate.Order;
import finances.domain.TransactionAggregate.Repository.TransactionRepository;
import finances.domain.TransactionAggregate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

// @Component
public class TransactionTestFactory extends TransactionFactory {

    private TransactionRepository transactionRepository;
    private int idCounter;

    @Autowired
    public TransactionTestFactory(TransactionRepository transactionRepository, FinancesClientTranslator financesClientTranslator) {
        this.financesClientTranslator = financesClientTranslator;
        this.transactionRepository = transactionRepository;
        idCounter =0;
    }

    @Override
    protected Transaction createTransaction(Order order) {
        Transaction transaction = new Transaction(idCounter++, order, new Date());
        transactionRepository.insert(transaction);
        return transaction;
    }
}
