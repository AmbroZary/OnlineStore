package finances.app.Services.RestServices;

import finances.app.Services.Interfaces.FinanceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinanceManagerRestAPI {

    private FinanceManager financeManager;

    @Autowired
    public FinanceManagerRestAPI(FinanceManager financeManager) {
        this.financeManager = financeManager;
    }

    @RequestMapping(value = "/order/paid", method = RequestMethod.POST)
    public ResponseEntity<String> paid(int id){
        financeManager.paid(id);
        return new ResponseEntity<String>("Opłacone", HttpStatus.OK);
    }
}
