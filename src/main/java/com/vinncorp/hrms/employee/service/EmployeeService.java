package com.vinncorp.hrms.employee.service;

import com.vinncorp.hrms.employee.dto.AddEmployeeDto;
import com.vinncorp.hrms.employee.model.Employee;
import com.vinncorp.hrms.global.Message;
import com.vinncorp.hrms.global.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public interface EmployeeService {

    Employee findOneByEmail(String email) throws RecordNotFoundException;

    Employee findOneByUsername(String username) throws RecordNotFoundException;

    Employee findOneById(Long id) throws RecordNotFoundException;

    List<Employee> findAll() throws RecordNotFoundException;

    Message getAll();

    List<Employee> findAllByCompanyId(Long id) throws RecordNotFoundException;

    Message addEmployee(AddEmployeeDto addEmployeeDto, Principal principal);

}
