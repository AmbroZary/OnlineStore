package logistic.domain.Services;


import logistic.domain.OrderAggregate.Address;
import org.springframework.stereotype.Component;

@Component
public class LogisticClientTranslator {

    public logistic.domain.OrderAggregate.Order translateFromClientToLogistic(
            client.domain.Aggregates.OrderAggregate.Order clientOrder) {
        return new logistic.domain.OrderAggregate.Order(clientOrder.getId(), translateAddress(clientOrder.getAddress()));
    }

    private logistic.domain.OrderAggregate.Address translateAddress(
            client.domain.Aggregates.OrderAggregate.OrderAddress clientOrderAddress){
        return new Address(clientOrderAddress.getName(), clientOrderAddress.getLastName(), clientOrderAddress.getStreet(),
                clientOrderAddress.getHouseNumber(), clientOrderAddress.getFlatNumber(), clientOrderAddress.getCity(),
                clientOrderAddress.getPostalCode(), clientOrderAddress.getPhoneNumber());
    }
}
