package finances.app.Services.RestServices;

import finances.app.Services.Interfaces.TransactionHistory;
import finances.domain.TransactionAggregate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionHistoryRestAPI {

    private TransactionHistory transactionHistory;

    @Autowired
    public TransactionHistoryRestAPI(TransactionHistory transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    @RequestMapping(value = "/transaction/history", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getTransactionHistory(){
        return new ResponseEntity<>(transactionHistory.getTransactionHistory(), HttpStatus.OK);
    }
}
