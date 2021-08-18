package com.vinncorp.hrms.company.service.impl;

import com.vinncorp.hrms.company.model.Company;
import com.vinncorp.hrms.company.repository.CompanyRepository;
import com.vinncorp.hrms.company.service.CompanyService;
import com.vinncorp.hrms.global.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company> getAll() throws RecordNotFoundException {
        List<Company> companies = companyRepository.findAllByIsActive(Boolean.TRUE);
        if (companies == null)
            throw new RecordNotFoundException("No records found in employee table");
        return companies;
    }

    @Override
    public Company getOneById(Long id) throws RecordNotFoundException {
        Company company = companyRepository.findOneByIdAndIsActive(id, Boolean.TRUE);
        if (company == null)
            throw new RecordNotFoundException("Cannot find employees by company id: " + id);
        return null;
    }

}
