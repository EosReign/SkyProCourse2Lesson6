import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {
    public ArrayList<Employee> arr = new ArrayList<Employee>();
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        arr.add(employee);
        return employee;
    }
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        arr.remove(employee);
        return employee;
    }
    public Employee searchEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        arr.indexOf(employee);
        return employee;
    }
}
