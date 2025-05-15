package module04.question44.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static module04.question44.EmployeeTestRepo.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void shouldStoreEmployeeAndFindById() {
        testEntityManager.merge(EMPLOYEE_1);
        testEntityManager.merge(EMPLOYEE_2);

        assertEquals(EMPLOYEE_1, testEntityManager.find(Employee.class, 1));
        assertEquals(EMPLOYEE_2, testEntityManager.find(Employee.class, 2));
    }
}