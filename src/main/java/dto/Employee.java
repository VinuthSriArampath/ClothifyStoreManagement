package dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private String employeeId;
    private String name;
    private String email;
    private String password;
    private String address;
    private String contact;
    private LocalDate hiredDate;

}
