package com.vinncorp.hrms.employee.service.impl;

import com.vinncorp.hrms.company.service.CompanyService;
import com.vinncorp.hrms.customMultiTenancy.model.Role;
import com.vinncorp.hrms.employee.dto.AddEmployeeDto;
import com.vinncorp.hrms.employee.mapper.EmployeeMapper;
import com.vinncorp.hrms.employee.model.Employee;
import com.vinncorp.hrms.employee.repository.EmployeeRepository;
import com.vinncorp.hrms.employee.service.EmployeeService;
import com.vinncorp.hrms.global.Message;
import com.vinncorp.hrms.global.exceptions.RecordNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService, UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public Employee findOneByEmail(String email) throws RecordNotFoundException {
        Employee employee = employeeRepository.findOneByEmailAndIsActive(email, Boolean.TRUE);
        if (employee == null)
            throw new RecordNotFoundException("Cannot find employee by email: " + email);
        return employee;
    }

    @Override
    public Employee findOneByUsername(String username) throws RecordNotFoundException {
        Employee employee = employeeRepository.findOneByUsernameAndIsActive(username, true);
        if (employee == null)
            throw new RecordNotFoundException("Cannot find employee by username: " + username);
        return employee;
    }

    @Override
    public Employee findOneById(Long id) throws RecordNotFoundException {
        Employee employee = employeeRepository.findOneByIdAndIsActive(id, true);
        if (employee == null)
            throw new RecordNotFoundException("Cannot find employee by id: " + id);
        return employee;
    }

    @Override
    public List<Employee> findAll() throws RecordNotFoundException {
        List<Employee> employees = employeeRepository.findAll();
        if (employees == null)
            throw new RecordNotFoundException("No records found in employee table");
        return employees;
    }

    @Override
    public List<Employee> findAllByCompanyId(Long id) throws RecordNotFoundException {
        List<Employee> employees = employeeRepository.findAllByCompanyIdAndIsActive(id, true);
        if (employees == null)
            throw new RecordNotFoundException("Cannot find employees by employee id: " + id);
        return employees;
    }

    @Override
    public Message<Employee> getAll() {
        Message message = new Message();
        try {
            return message.setData(findAll()).setStatus(200).setCode("Success").setMessage("List of all employees retrieved successfully");
        } catch (RecordNotFoundException e) {
            log.error("Cannot add employee, because: " + e.getMessage());
            return message.setStatus(404).setCode("Failure").setMessage("Cannot add employee, because: " + e.getMessage());
        }
    }

    Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Message addEmployee(AddEmployeeDto addEmployeeDto, Principal principal) {
        Message message = new Message();
        try {
            Employee employee = save(employeeMapper.mapFromAddEmployeeDto(addEmployeeDto, principal));
            return message.setStatus(200).setCode("Success").setMessage("Employees added successfully!").setData(employee);
        } catch (Exception e) {
            log.error("Cannot add employee, because: " + e.getMessage());
            return message.setStatus(201).setCode("Failure").setMessage("Employees cannot be added!");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findOneByEmail(s);
        if (employee == null) {

            employee = employeeRepository.findOneByUsername(s);
            if (employee == null)
                return null;
        }
        return new org.springframework.security.core.userdetails.User(
                employee.getEmail(), employee.getPassword(), employee.getIsActive(), true, true,
                true, getAuthorities(employee.getRole()));
    }

    public Collection<GrantedAuthority> getAuthorities(Role role) {

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new GrantedAuthority() {
            public String getAuthority() {
                return role.getType();
            }
        };
        grantedAuthorities.add(grantedAuthority);
        return grantedAuthorities;
    }


}
