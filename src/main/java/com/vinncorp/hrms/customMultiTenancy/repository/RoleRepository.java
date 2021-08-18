package com.vinncorp.hrms.customMultiTenancy.repository;

import com.vinncorp.hrms.customMultiTenancy.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findOneByType(String type);

    Role findOneById(Long id);

    ArrayList<Role> findAllByType(String type);

}
