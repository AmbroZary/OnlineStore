package client.app.Services.RestServices;

import client.app.Services.Interfaces.StateManagers.FinanceStateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinanceStateManagerRestAPI {

    private FinanceStateManager financeStateManager;

    @Autowired
    public FinanceStateManagerRestAPI(FinanceStateManager financeStateManager) {
        this.financeStateManager = financeStateManager;
    }

    @RequestMapping(value = "state/paid", method = RequestMethod.POST)
    public ResponseEntity<String> changeOrderStateToPaid(int id) {
        try{
            financeStateManager.changeOrderStateToPaid(id);
        }
        catch (NullPointerException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<String>("Zamówienie zostało opłacone", HttpStatus.OK);
    }
}
