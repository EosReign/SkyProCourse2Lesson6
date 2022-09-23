import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public Employee[] arr = new Employee[5];
    public String addEmployee(String firstName, String lastName) throws EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName);

        for (int i = 0; i < arr.length; i++) {
            try {
                checkEmployeeAlreadyAddedException(i, firstName, lastName);
            } catch (EmployeeAlreadyAddedException e) {
                return e.getMessage();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = employee;
                return "firstName: " + firstName + ", lastName: " + lastName;
            }
        }
        throw new EmployeeStorageIsFullException("ArrayIsFull");
    }
    public String removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].getFirstName().equals(firstName) && arr[i].getLastName().equals(lastName)) {
                    arr[i] = null;
                    return "firstName: " + firstName + ", lastName: " + lastName;
                }
            }
        }
        throw new EmployeeNotFoundException("EmployeeNotFound");
    }
    public String searchEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].getFirstName().equals(firstName) && arr[i].getLastName().equals(lastName)) {
                    //System.out.println("Сотрудник: " + arr[i].toString() + " найден по индексу - " + i);
                    return "firstName: " + firstName + ", lastName: " + lastName;
                }
            }
        }
        throw new EmployeeNotFoundException("EmployeeNotFound");
    }
    public void checkEmployeeAlreadyAddedException(int i, String firstName, String lastName) throws EmployeeAlreadyAddedException {
        if (arr[i].getFirstName().equals(firstName) && arr[i].getLastName().equals(lastName)) {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
        }
    }
}
