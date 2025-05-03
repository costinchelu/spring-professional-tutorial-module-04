package module04.question23.application;

import module04.question23.auto.configuration.filestore.FileStore;
import module04.question23.auto.configuration.java.JavaEnvInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    private final JavaEnvInfo javaEnvInfo;

    private final EmployeesService employeesService;

    private final FileStore fileStore;

    public Runner(JavaEnvInfo javaEnvInfo, EmployeesService employeesService, FileStore fileStore) {
        this.javaEnvInfo = javaEnvInfo;
        this.employeesService = employeesService;
        this.fileStore = fileStore;
    }

    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        javaEnvInfo.printJvmEnvInfo();
        fileStore.printFileStoreInfo();
        employeesService.printEmails();
    }
}
