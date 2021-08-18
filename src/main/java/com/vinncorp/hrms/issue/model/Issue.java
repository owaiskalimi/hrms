package com.vinncorp.hrms.issue.model;

import com.vinncorp.hrms.general.models.General;
import com.vinncorp.hrms.employee.model.Employee;

import javax.persistence.*;

@Entity
public class Issue extends General {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Column
    private boolean isResolved;

    @ManyToOne
    @JoinColumn
    private Employee resolvedBy;

}
