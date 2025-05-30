package module04.question44.dao;

import module04.question44.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findByEmail(String email);
}
