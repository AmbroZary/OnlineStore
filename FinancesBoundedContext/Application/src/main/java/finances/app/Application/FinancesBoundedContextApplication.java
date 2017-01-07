package finances.app.Application;

import common.Classes.Application;
import common.HibernateUtil;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"finances"})
public class FinancesBoundedContextApplication extends Application {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        SpringApplication.run(FinancesBoundedContextApplication.class, args);
    }

    static Logger log = Logger.getLogger(FinancesBoundedContextApplication.class.getName());
}