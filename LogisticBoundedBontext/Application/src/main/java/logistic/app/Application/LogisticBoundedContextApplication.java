package logistic.app.Application;

import common.Classes.Application;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = { "logistic" })
public class LogisticBoundedContextApplication extends Application{
    public static void main(String[] args) {
        SpringApplication.run(LogisticBoundedContextApplication.class, args);
    }

    static Logger log = Logger.getLogger(LogisticBoundedContextApplication.class.getName());

}
