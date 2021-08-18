package com.vinncorp.hrms.employee.mapper;

import com.vinncorp.hrms.company.service.CompanyService;
import com.vinncorp.hrms.customMultiTenancy.service.RoleService;
import com.vinncorp.hrms.employee.dto.AddEmployeeDto;
import com.vinncorp.hrms.employee.model.Employee;
import com.vinncorp.hrms.employee.service.EmployeeService;
import com.vinncorp.hrms.global.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Timestamp;

@Service
public class EmployeeMapper {

    @Autowired
    CompanyService companyService;

    @Autowired
    RoleService roleService;

    @Autowired
    EmployeeService employeeService;

    public Employee mapFromAddEmployeeDto(AddEmployeeDto addEmployeeDto, Principal principal) {
        Employee employee = null;
        try {
            employee = new Employee(
                    new Timestamp(System.currentTimeMillis()),
                    employeeService.findOneByEmail(principal.getName()),
                    true,
                    addEmployeeDto.getUsername(),
                    addEmployeeDto.getEmail(),
                    addEmployeeDto.getPassword(),
                    addEmployeeDto.getName(),
                    addEmployeeDto.getAddress(),
                    addEmployeeDto.getPhone(),
                    addEmployeeDto.getDesignation(),
                    companyService.getOneById(addEmployeeDto.getCompanyId()),
                    roleService.findOneByType(addEmployeeDto.getRole())
            );
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        }
        return employee;
    }

}
