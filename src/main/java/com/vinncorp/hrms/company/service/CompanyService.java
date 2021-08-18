package com.vinncorp.hrms.company.service;

import com.vinncorp.hrms.company.model.Company;
import com.vinncorp.hrms.global.exceptions.RecordNotFoundException;

import java.util.List;

public interface CompanyService {

    List<Company> getAll() throws RecordNotFoundException;

    Company getOneById(Long id) throws RecordNotFoundException;

}
