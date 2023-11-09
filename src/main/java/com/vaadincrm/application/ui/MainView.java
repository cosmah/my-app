package com.vaadincrm.application.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadincrm.application.backend.entity.Contact;
import com.vaadincrm.application.backend.service.ContactService;

//1. FIRST DEFINE ENTRY ROUTE
@Route("")
public class MainView extends VerticalLayout {
    private ContactService contactService;

    // Defines a new field grid and instantiates it to a Grid of type Contact
    private Grid<Contact> grid = new Grid<>(Contact.class);

    public MainView(ContactService contactService) {
        // Saves ContactService in a field, so you have easy access to it later
        this.contactService = contactService;
        // Gives the component a CSS class name to help with styling
        addClassName("list-view");
        // Calls setSizeFull() to make MainView take up the full size of the browser
        // window
        setSizeFull();
        // Splits the grid configuration into a separate method
        configureGrid();

        // Adds the grid to the main layout using the add(grid) method
        add(grid);
        // Creates a new method, updateList(), that fetches all contacts from the
        // service, and passes them to the grid.
        updateList();
    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        // Defines the properties of a Contact to shown using the grid.setColumns(..)
        // method.
        grid.setColumns("firstName", "lastName", "email", "status");
    }

    // ------TABLE-----
    private void updateList() {
        grid.setItems(contactService.findAll());
    }

}