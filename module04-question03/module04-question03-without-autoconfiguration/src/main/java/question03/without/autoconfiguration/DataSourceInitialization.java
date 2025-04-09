package question03.without.autoconfiguration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@AllArgsConstructor
@Component
public class DataSourceInitialization implements InitializingBean {

    private DataSource dataSource;

    @Override
    public void afterPropertiesSet() throws Exception {
        new ResourceDatabasePopulator(
                new ClassPathResource("import.sql")
        ).execute(dataSource);
    }
}
