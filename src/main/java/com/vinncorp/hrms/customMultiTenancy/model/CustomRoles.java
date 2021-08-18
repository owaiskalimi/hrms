package com.vinncorp.hrms.customMultiTenancy.model;

import com.vinncorp.hrms.employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CustomRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Role role;

    @ManyToOne
    @JoinColumn
    private Employee employee;

}
