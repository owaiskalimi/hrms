package com.vinncorp.hrms.employee.model;

import com.vinncorp.hrms.company.model.Company;
import com.vinncorp.hrms.customMultiTenancy.model.Role;
import com.vinncorp.hrms.general.models.Created;
import com.vinncorp.hrms.general.models.General;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
public class Employee extends General {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String designation;

    @ManyToOne
    @JoinColumn
    private Company company;

    @ManyToOne
    @JoinColumn
    private Role role;

    public Employee(Timestamp createdAt, Employee createdBy, Boolean isActive, String username, String email, String password, String name, String address, String phone, String designation, Company company, Role role) {
        super(createdAt, createdBy, isActive);
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.designation = designation;
        this.company = company;
        this.role = role;
    }

}
