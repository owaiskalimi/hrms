package com.vinncorp.hrms.customMultiTenancy.service.impl;

import com.vinncorp.hrms.customMultiTenancy.model.Role;
import com.vinncorp.hrms.customMultiTenancy.repository.RoleRepository;
import com.vinncorp.hrms.customMultiTenancy.service.RoleService;
import com.vinncorp.hrms.global.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findOneByType(String type) throws RecordNotFoundException {
        Role role = roleRepository.findOneByType(type);
        if(role == null)
            throw new RecordNotFoundException("Cannot find role by type: " + type);
        return role;
    }

    @Override
    public Role findOneById(Long id) throws RecordNotFoundException {
        Role role = roleRepository.findOneById(id);
        if(role == null)
            throw new RecordNotFoundException("Cannot find role by id: " + id);
        return null;
    }

    @Override
    public ArrayList<Role> findAllByType(String type) throws RecordNotFoundException {
        ArrayList<Role> roles = roleRepository.findAllByType(type);
        if(roles == null)
            throw new RecordNotFoundException("Cannot find role by type: " + type);
        return roles;
    }
}
