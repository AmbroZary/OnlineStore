package finances.app.Services.Interfaces;

import finances.domain.TransactionAggregate.Transaction;

import java.util.List;

public interface TransactionHistory {

    List<Transaction> getTransactionHistory();
}
