package service.custom;

import dto.Employee;
import entity.EmployeeEntity;
import javafx.collections.ObservableList;

public interface EmployeeService {
    boolean addEmployee(Employee employee);
    Employee searchEmployee(String id);
    boolean updateEmployee(Employee employee);
    ObservableList<EmployeeEntity> getAllEmployees();
    boolean deleteEmployee(String id);
}
