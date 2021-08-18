package com.vinncorp.hrms.customMultiTenancy.service;

import com.vinncorp.hrms.customMultiTenancy.model.Role;
import com.vinncorp.hrms.global.exceptions.RecordNotFoundException;

import java.util.ArrayList;

public interface RoleService {

    Role findOneByType(String type) throws RecordNotFoundException;

    Role findOneById(Long id) throws RecordNotFoundException;

    ArrayList<Role> findAllByType(String type) throws RecordNotFoundException;

}
