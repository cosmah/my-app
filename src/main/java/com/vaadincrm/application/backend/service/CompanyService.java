package com.vaadincrm.application.backend.service;

import com.vaadincrm.application.backend.entity.Company;
import com.vaadincrm.application.backend.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;

    
    public CompanyService(CompanyRepository companyRepository) {

        this.companyRepository = companyRepository;
    }

    public List<Company> findAll(){
        return companyRepository.findAll();
    }
}
