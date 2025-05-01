package module04.question19.application;

import module04.question19.application.service.ServiceA;
import module04.question19.extra.service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//@SpringBootApplication(scanBasePackageClasses = {SpringBootConsoleApplication.class, ServiceB.class})
@SpringBootApplication(scanBasePackages = {"module04.question19"})
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private ServiceA serviceA;

    @Autowired
    private ServiceB serviceB;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
    }
}
