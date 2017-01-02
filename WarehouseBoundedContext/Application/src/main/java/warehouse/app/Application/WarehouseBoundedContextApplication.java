package warehouse.app.Application;

import common.Classes.Application;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "warehouse" })
public class WarehouseBoundedContextApplication extends Application{
    public static void main(String[] args) {
        SpringApplication.run(WarehouseBoundedContextApplication.class, args);
    }

    static Logger log = Logger.getLogger(WarehouseBoundedContextApplication.class.getName());
}