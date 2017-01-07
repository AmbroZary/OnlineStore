package finances.infrastructure.Factories;

import finances.domain.Services.FinancesClientTranslator;
import finances.domain.TransactionAggregate.Factory.TransactionFactory;
import finances.domain.TransactionAggregate.Order;
import finances.domain.TransactionAggregate.Repository.TransactionRepository;
import finances.domain.TransactionAggregate.Transaction;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransactionDBFactory extends TransactionFactory {

    private TransactionRepository transactionRepository;

    public TransactionDBFactory(TransactionRepository transactionRepository, FinancesClientTranslator financesClientTranslator) {
        this.transactionRepository = transactionRepository;
        this.financesClientTranslator = financesClientTranslator;
    }

    @Override
    protected Transaction createTransaction(Order order) {
        Transaction transaction = new Transaction(order, new Date());
        transactionRepository.insert(transaction);
        return transaction;
    }
}
