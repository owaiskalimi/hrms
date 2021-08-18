package com.vinncorp.hrms.employee.repository;

import com.vinncorp.hrms.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findOneByEmailAndIsActive(String email, boolean isActive);

    Employee findOneByUsernameAndIsActive(String userName, boolean isActive);

    Employee findOneByIdAndIsActive(Long id, boolean isActive);

    ArrayList<Employee> findAllByIsActive(boolean isActive);

    ArrayList<Employee> getAllByIsActive(boolean isActive);

    ArrayList<Employee> findAllByCompanyIdAndIsActive(Long id, boolean isActive);

    Employee findOneByEmail(String s);

    Employee findOneByUsername(String s);
}
