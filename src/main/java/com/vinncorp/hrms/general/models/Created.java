package com.vinncorp.hrms.general.models;

import com.vinncorp.hrms.employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public abstract class Created {

    @ManyToOne
    @JoinColumn
    public Employee createdBy;

    @Column
    public Timestamp createdAt;

    @Column
    public Boolean isActive;

}
