package com.vinncorp.hrms.employee.controller;

import com.vinncorp.hrms.employee.dto.AddEmployeeDto;
import com.vinncorp.hrms.employee.service.EmployeeService;
import com.vinncorp.hrms.global.Message;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getAll")
    public ResponseEntity getAllEmployees() {
        Message message = employeeService.getAll();
        return ResponseEntity.status(message.getStatus()).body(message);
    }

    @GetMapping("/add")
    public ResponseEntity addEmployee(@RequestBody AddEmployeeDto addEmployeeDto) {

    }


}
