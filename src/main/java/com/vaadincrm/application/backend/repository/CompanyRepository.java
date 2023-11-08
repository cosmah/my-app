package com.vaadincrm.application.backend.repository;

import com.vaadincrm.application.backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>{
}
