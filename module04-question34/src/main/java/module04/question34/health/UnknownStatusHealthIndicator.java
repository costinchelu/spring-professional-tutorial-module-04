package module04.question34.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class UnknownStatusHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.unknown()
                .build();
    }
}
