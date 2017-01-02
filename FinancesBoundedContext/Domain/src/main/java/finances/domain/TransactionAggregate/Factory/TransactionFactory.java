package finances.domain.TransactionAggregate.Factory;
import finances.domain.Services.FinancesClientTranslator;
import finances.domain.TransactionAggregate.Order;
import finances.domain.TransactionAggregate.Transaction;


public abstract class TransactionFactory {
    protected FinancesClientTranslator financesClientTranslator;

    public Transaction createTransaction( client.domain.Aggregates.OrderAggregate.Order order){
        return createTransaction(financesClientTranslator.TranslateFromClientToFinances(order));
    }

    protected abstract Transaction createTransaction(Order order);
}
