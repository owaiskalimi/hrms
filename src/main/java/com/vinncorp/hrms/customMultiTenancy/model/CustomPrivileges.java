package com.vinncorp.hrms.customMultiTenancy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CustomPrivileges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private CustomRoles customRoles;

    @ManyToOne
    @JoinColumn
    private Privileges privileges;

}
