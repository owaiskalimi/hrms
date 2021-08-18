package com.vinncorp.hrms.attendance.model;

import com.vinncorp.hrms.general.models.Updated;
import com.vinncorp.hrms.employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Attendance extends Updated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Timestamp timeIn;

    @Column
    private Timestamp timeOut;

    @Column
    private String status;

    @Column
    private String hours;

    @Column
    private Date date;

    @Column
    private String macAddress;

    @ManyToOne
    @JoinColumn
    Employee employee;

}
