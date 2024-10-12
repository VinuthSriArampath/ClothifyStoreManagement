package dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Integer employeeId;
    private String name;
    private String email;
    private String password;
    private String address;
    private String contact;

    public Employee(String name, String email, String password, String address, String contact) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contact = contact;
    }
}
