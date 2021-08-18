package com.vinncorp.hrms.system.model;

import com.vinncorp.hrms.general.models.General;
import com.vinncorp.hrms.employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class System extends General {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Employee user;

    @Column
    private String macAddress;

}
