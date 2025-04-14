package module04.question08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppConfiguration.class)
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private AppConfiguration appConfiguration;

    // launch with --spring.profiles.active=dev and working directory pointing to work-dir
    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(appConfiguration);
    }
}
// change name of the default config file (use program arguments):
// java -jar myapp.jar --spring.config.name=dev
// so to get properties from application-dev files

// also observe propertyR that will be taken from application-dev.properties in resources/config even though we have it also in application.properties

// change the location of the default config file:
// java -jar myapp.jar --spring.config.location=classpath:/default.properties
// (use working directory) to point out absolute path of working-directory
// should display:
// AppConfiguration(propertyA=1, propertyB=2, propertyC=3, propertyD=4, propertyE=5, propertyF=6, propertyG=7,
// propertyH=8, propertyI=9, propertyJ=10, propertyK=11, propertyL=12, propertyM=13, propertyN=14,
// propertyO=15, propertyP=16)
