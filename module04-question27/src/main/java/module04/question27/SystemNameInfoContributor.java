package module04.question27;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

// add additional info to the endpoint /actuator/info
@Component
public class SystemNameInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("system-name", System.getProperty("os.name"));
    }
}
