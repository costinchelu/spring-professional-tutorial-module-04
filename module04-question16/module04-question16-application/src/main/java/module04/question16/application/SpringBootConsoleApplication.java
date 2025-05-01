package module04.question16.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public SpringBootConsoleApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Fetching employees e-mails");
        jdbcTemplate
                .queryForList("select email from employee", String.class)
                .forEach(System.out::println);
    }
}
