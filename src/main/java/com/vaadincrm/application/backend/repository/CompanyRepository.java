package com.vaadincrm.application.backend.repository;

import com.vaadincrm.application.backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    // Your repository methods here
}
