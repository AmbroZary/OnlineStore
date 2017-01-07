package warehouse.app.Application;

import common.Classes.Application;
import common.HibernateUtil;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import warehouse.app.Services.DataInitializer;

import java.io.IOException;

@SpringBootApplication(scanBasePackages = { "warehouse" })
public class WarehouseBoundedContextApplication extends Application{
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WarehouseBoundedContextApplication.class, args);
        DataInitializer dataInitializer = ctx.getBean(DataInitializer.class);
        try {
            dataInitializer.initializeData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static Logger log = Logger.getLogger(WarehouseBoundedContextApplication.class.getName());
}