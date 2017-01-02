package finances.domain.Services;

import client.domain.Aggregates.OrderAggregate.Order;
import org.springframework.stereotype.Component;

@Component
public class FinancesClientTranslator {

    public finances.domain.TransactionAggregate.Order TranslateFromClientToFinances(Order clientOrder){
        return new finances.domain.TransactionAggregate.Order(clientOrder.getId(), clientOrder.getPrice());
    }
}
