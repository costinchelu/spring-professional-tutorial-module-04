package question06.java.properties;

import lombok.AllArgsConstructor;
import question06.java.properties.configuration.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@AllArgsConstructor
@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfiguration.class)
public class SpringBootConsoleApplication implements CommandLineRunner {

    private ApplicationConfiguration applicationConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Configuration injected from properties:");
        System.out.println(applicationConfiguration);
    }
}
