package com.vaadincrm.application.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadincrm.application.backend.entity.Contact;


//1. FIRST DEFINE ENTRY ROUTE
@Route("")
public class MainView extends VerticalLayout {

    //define UI
  private Grid<Contact> grid = new Grid<>(Contact.class); 
  public MainView() {
  addClassName("list-view"); 
  setSizeFull(); 
  configureGrid(); 
  add(grid); 
  }
  private void configureGrid() {
  grid.addClassName("contact-grid");
  grid.setSizeFull();
  grid.setColumns("firstName", "lastName", "email", "status"); 
  }

  //------TABLE-----

}