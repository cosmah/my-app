package com.vaadincrm.application.backend.service;

import com.vaadincrm.application.backend.entity.Company;
import com.vaadincrm.application.backend.entity.Contact;
import com.vaadincrm.application.backend.repository.CompanyRepository;
import com.vaadincrm.application.backend.repository.ContactRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ContactService {
    private static final Logger LOGGER = Logger.getLogger(ContactService.class.getName());
    private ContactRepository contactRepository;
    private CompanyRepository companyRepository;
    public ContactService(ContactRepository contactRepository, CompanyRepository companyRepository){
        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
    }

    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    public long count(){
        return contactRepository.count();
    }

    public void delete(Contact contact){
        contactRepository.delete(contact);
    }

    public void save(Contact contact){
        if (contact == null){
            LOGGER.log(Level.SEVERE,
                    "Contact is null, Please reconnect");
            return;
        }
        contactRepository.save(contact);
    }

    //populate in data
    @PostConstruct //this annotation tells spring to run this method after constructing ContactService
    public void populateTestData() {
        if (companyRepository.count() == 0) {
            companyRepository.saveAll(
                    Stream.of("Path-Way Electronics", "E-Tech Management", "Path-E-Tech Management")
                                    .map(Company::new)
                                    .collect(Collectors.toList()));
        }
        if (contactRepository.count() == 0) {
            Random r = new Random(0);
            List<Company> companies = companyRepository.findAll();
            contactRepository.saveAll(
                    Stream.of("Gabrielle Patel", "Brian Robinson", "Eduardo Haugen",
                                    "Koen Johansen", "Alejandro Macdonald", "Angel Karlsson", "Yahir Gustavsson", "Haiden Svensson",
                                    "Emily Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson",
                                    "Kelly Gustavsson",
                                    "Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
                                    "Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson ", "Lara Martin",
                                    "Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
                                    "Jaydan Jackson", "Bernard Nilsen")
                            .map(name -> {
                                String[] split = name.split(" ");
                                Contact contact = new Contact();
                                contact.setFirstName(split[0]);
                                contact.setLastName(split[1]);
                                contact.setCompany(companies.get(r.nextInt(companies.size())));
                                contact.setStatus(Contact.Status.values()[r.nextInt(Contact
                                        .Status.values().length)]);
                                String email = (contact.getFirstName() + "." + contact
                                        .getLastName() + "@" + contact.getCompany().getName().replaceAll("[\\s-]", "") +
                                        ".com").toLowerCase();
                                contact.setEmail(email);
                                return contact;
                            }).collect(Collectors.toList()));
        }
    }
}

