package module04.question42.controller;

import module04.question42.dao.CityDao;
import module04.question42.dao.EmployeeDao;
import module04.question42.ds.EmployeePutRequest;
import module04.question42.ds.Employees;
import module04.question42.entity.City;
import module04.question42.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CityDao cityDao;

    @GetMapping("/employees")
    public Employees getEmployees() {
        return new Employees(employeeDao.findAll());
    }

    @PutMapping("/employees")
    public void putEmployee(@RequestBody EmployeePutRequest employeePutRequest) {
        String requestedCity = employeePutRequest.getCity();
        Optional<City> city = cityDao.findByName(requestedCity);

        City employeeCity = city.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Employee City [%s] not found", requestedCity))
        );

        employeeDao.save(new Employee(employeePutRequest.getName(), employeeCity));
    }
}
