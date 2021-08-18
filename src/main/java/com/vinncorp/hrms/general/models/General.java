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
public abstract class General {

    @Column
    public Timestamp createdAt;

    @ManyToOne
    @JoinColumn
    public Employee createdBy;

    @Column
    public Timestamp updatedAt;

    @ManyToOne
    @JoinColumn
    public Employee updatedBy;

    @Column
    public Boolean isActive;

    public General(Timestamp createdAt, Employee createdBy, Boolean isActive) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.isActive = isActive;
    }
}
