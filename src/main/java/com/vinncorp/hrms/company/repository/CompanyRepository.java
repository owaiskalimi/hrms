package com.vinncorp.hrms.company.repository;

import com.vinncorp.hrms.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findAllByIsActive(Boolean isActive);

    Company findOneByIdAndIsActive(Long id, boolean b);

}
