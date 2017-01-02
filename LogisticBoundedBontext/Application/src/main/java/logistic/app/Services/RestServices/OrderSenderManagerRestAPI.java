package logistic.app.Services.RestServices;


import logistic.app.Services.Interfaces.OrderSenderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderSenderManagerRestAPI {

    private OrderSenderManager orderSenderManager;

    @Autowired
    public OrderSenderManagerRestAPI(OrderSenderManager orderSenderManager) {
        this.orderSenderManager = orderSenderManager;
    }



    @RequestMapping("/order/send")
    public ResponseEntity<String> sendOrder(int id){
        orderSenderManager.sendOrder(id);
        return new ResponseEntity<String>("Paczka wysłana", HttpStatus.OK);
    }



}
