package client.app.Application;

import common.Classes.Application;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "client" })
public class ClientBoundedContextApplication extends Application{
    public static void main(String[] args) {
        SpringApplication.run(ClientBoundedContextApplication.class, args);
    }

    static Logger log = Logger.getLogger(ClientBoundedContextApplication.class.getName());

}
