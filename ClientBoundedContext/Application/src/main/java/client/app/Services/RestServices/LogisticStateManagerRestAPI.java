package client.app.Services.RestServices;

import client.app.Services.Interfaces.StateManagers.LogisticStateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogisticStateManagerRestAPI {

    private LogisticStateManager logisticStateManager;

    @Autowired
    public LogisticStateManagerRestAPI(LogisticStateManager logisticStateManager) {
        this.logisticStateManager = logisticStateManager;
    }

    @RequestMapping(value = "/state/sent", method = RequestMethod.POST)
    public ResponseEntity<String> changeOrderStateToSent(int id) {
        try{
            logisticStateManager.changeOrderStateToSent(id);
        }
        catch (NullPointerException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<String>("Zamówienie zostało wysłane", HttpStatus.OK);

    }

    @RequestMapping(value = "/state/provided", method = RequestMethod.POST)
    public ResponseEntity<String> changeOrderStateToProvided(int id) {
        try{
            logisticStateManager.changeOrderStateToProvided(id);
        }
        catch (NullPointerException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<String>("Zamówienie zostało dostarczone", HttpStatus.OK);

    }
}
