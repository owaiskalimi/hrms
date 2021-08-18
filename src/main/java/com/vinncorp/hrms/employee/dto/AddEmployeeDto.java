package com.vinncorp.hrms.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddEmployeeDto {

    private String name;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String designation;
    private String role;
    private Long companyId;

}
