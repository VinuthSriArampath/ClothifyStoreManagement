package controller.dto_controllers;
import dto.Employee;
import entity.EmployeeEntity;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import service.custom.EmployeeService;
import service.custom.impl.EmployeeServiceImpl;
import java.util.regex.Pattern;


public class EmployeeController {
    private EmployeeService employeeService= new EmployeeServiceImpl();
    private static EmployeeController instance;
    private EmployeeController(){}

    public static EmployeeController getInstance() {
        return instance==null?instance=new EmployeeController():instance;
    }

    public Boolean validateEmployee(String employeeName, String employeeEmail, String employeePassword, String employeeAddress,String employeeContact){
        String regPasswordPattern ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#^$%!&*])[A-Za-z\\d@#^$%!&]{8,}$";
        String regEmailPattern = "^[A-Za-z0-9._%+-]+@gmail\\.com$";
        String regContactPatter = "^0[\\d]{9}$";

        Pattern emailPattern = Pattern.compile(regEmailPattern);
        Pattern passwordPattern = Pattern.compile(regPasswordPattern);
        Pattern contactPattern = Pattern.compile(regContactPatter);

        if(employeeName.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Employee Name").showAndWait();
            return false;
        } else if (!emailPattern.matcher(employeeEmail).matches()) {
            new Alert(Alert.AlertType.ERROR,"Invalid Email Address").showAndWait();
            return false;
        } else if (!passwordPattern.matcher(employeePassword).matches() ) {
            new Alert(Alert.AlertType.ERROR,"Invalid Password, Password should contain.\nAt Least 1 Capital Letter.\nAt Least 1 Simple Letter.\nAt Least 1 Number[0-9].\nAt Least 1 Special Character[@#^$%!&].").showAndWait();
            return false;
        } else if (!contactPattern.matcher(employeeContact).matches()) {
            new Alert(Alert.AlertType.ERROR,"Invalid Contact Number").showAndWait();
            return false;
        } else if (employeeAddress.isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Invalid Employee Address").showAndWait();
            return false;
        }else {
            return true;
        }
    }
    public Boolean validateEmployeeOnUpdate(String employeeName, String employeeEmail, String employeeAddress,String employeeContact){
        String regEmailPattern = "^[A-Za-z0-9._%+-]+@gmail\\.com$";
        String regContactPatter = "^0[\\d]{9}$";

        Pattern emailPattern = Pattern.compile(regEmailPattern);
        Pattern contactPattern = Pattern.compile(regContactPatter);

        if(employeeName.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Employee Name").showAndWait();
            return false;
        } else if (!emailPattern.matcher(employeeEmail).matches()) {
            new Alert(Alert.AlertType.ERROR,"Invalid Email Address").showAndWait();
            return false;
        }  else if (!contactPattern.matcher(employeeContact).matches()) {
            new Alert(Alert.AlertType.ERROR,"Invalid Contact Number").showAndWait();
            return false;
        } else if (employeeAddress.isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Invalid Employee Address").showAndWait();
            return false;
        }else {
            return true;
        }
    }

    public boolean addEmployee(Employee employee){
        return employeeService.addEmployee(employee);
    }

    public Employee searchEmployeeById(String id){
        return employeeService.searchEmployee(id);
    }

    public boolean updateEmployee(Employee employee){
        return employeeService.updateEmployee(employee);
    }
    public boolean deleteEmployee(String id){
        return employeeService.deleteEmployee(id);
    }
    public ObservableList<EmployeeEntity> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    public String genarateEmployeeId(){
        ObservableList<EmployeeEntity> allEmployees = employeeService.getAllEmployees();
        int id = allEmployees.isEmpty() ?1:Integer.parseInt((allEmployees.getLast().getEmployeeId().split("Emp")[1]))+1;
        return "Emp"+id;
    }

}
