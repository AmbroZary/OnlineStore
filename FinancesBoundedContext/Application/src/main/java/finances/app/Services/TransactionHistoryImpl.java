package finances.app.Services;

import finances.app.Services.Interfaces.TransactionHistory;
import finances.domain.TransactionAggregate.Repository.TransactionRepository;
import finances.domain.TransactionAggregate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionHistoryImpl implements TransactionHistory{

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionHistoryImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getTransactionHistory() {
        return transactionRepository.findAll();
    }
}
