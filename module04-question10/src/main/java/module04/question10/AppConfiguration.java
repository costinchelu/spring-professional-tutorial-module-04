package module04.question10;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

// needs getters and setters for each property

@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppConfiguration {
    private String propertyA;
}
