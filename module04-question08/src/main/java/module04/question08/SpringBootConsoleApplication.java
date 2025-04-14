package module04.question08;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@AllArgsConstructor
@SpringBootApplication
@EnableConfigurationProperties(AppConfiguration.class)
public class SpringBootConsoleApplication implements CommandLineRunner {

    private AppConfiguration appConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(appConfiguration);
    }
}
// in case two identical property keys are found in application.properties and application-dev.properties,
// then the profile will decide from where the value is taken

// change name of the default config file (use program arguments):
// java -jar myapp.jar --spring.config.name=dev
// so to get properties from application-dev files

// change the location of the default config file:
// java -jar myapp.jar --spring.config.location=classpath:/default.properties
// (use working directory) to point out absolute path of working-directory
// example:

// no args
// should display:
// propertyA=1, propertyB=2, propertyC=0, propertyD=0,
// propertyE=5, propertyF=6, propertyG=0, propertyH=0,
// propertyI=0, propertyJ=0, propertyK=0, propertyL=0,
// propertyM=0, propertyN=0, propertyO=0, propertyP=0)

// --spring.profiles.active=dev
// should display:
// propertyA=1, propertyB=2, propertyC=3, propertyD=4,
// propertyE=5, propertyF=6, propertyG=7, propertyH=8,
// propertyI=0, propertyJ=0, propertyK=0, propertyL=0,
// propertyM=0, propertyN=0, propertyO=0, propertyP=0)

// --spring.profiles.active=dev --spring.config.location=file:/C:/CODE/spring-professional-tutorial-module-04/module04-question08/work-dir/
// should display:
// (propertyA=0, propertyB=0, propertyC=0, propertyD=0,
// propertyE=0, propertyF=0, propertyG=0, propertyH=0,
// propertyI=0, propertyJ=0, propertyK=0, propertyL=0,
// propertyM=13, propertyN=14, propertyO=15, propertyP=16)

// --spring.profiles.active=dev --spring.config.location=file:/C:/CODE/spring-professional-tutorial-module-04/module04-question08/work-dir/config/
// should display:
// propertyA=0, propertyB=0, propertyC=0, propertyD=0,
// propertyE=0, propertyF=0, propertyG=0, propertyH=0,
// propertyI=9, propertyJ=10, propertyK=11, propertyL=12,
// propertyM=0, propertyN=0, propertyO=0, propertyP=0)



