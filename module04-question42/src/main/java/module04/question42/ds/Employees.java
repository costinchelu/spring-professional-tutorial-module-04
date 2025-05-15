package module04.question42.ds;

import lombok.NoArgsConstructor;
import module04.question42.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employees {

    private Iterable<Employee> employees;
}
