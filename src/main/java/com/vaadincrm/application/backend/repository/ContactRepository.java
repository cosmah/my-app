package com.vaadincrm.application.backend.repository;

import com.vaadincrm.application.backend.entity.Contact;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.*;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
