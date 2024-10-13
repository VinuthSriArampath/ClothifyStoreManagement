package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="employee")
public class EmployeeEntity {
    @Id
    private String employeeId;
    private String name;
    private String email;
    private String password;
    private String address;
    private String contact;
    private LocalDate hiredDate;
}
