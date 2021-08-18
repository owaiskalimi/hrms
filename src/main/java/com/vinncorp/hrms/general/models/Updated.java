package com.vinncorp.hrms.general.models;

import com.vinncorp.hrms.employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public abstract class Updated {

    @ManyToOne
    @JoinColumn
    public Employee updatedBy;

    @Column
    public Timestamp updatedAt;

}
