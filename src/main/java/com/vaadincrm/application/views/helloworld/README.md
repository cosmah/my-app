#THIS IS THE CONTENT THAT HAS BEEN PREVIOUSLY IN THE MAINVIEW.JAVA CLASS
package com.vaadincrm.application.views.helloworld;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


//1. FIRST DEFINE ENTRY ROUTE
@Route("")
public class MainView extends VerticalLayout {

    //2. Set up component
    public MainView(){
        //default element of the empty route we first created
        Button button = new Button("Click me !!!");
        DatePicker datePicker = new DatePicker("Pick a date");
        //what is nested in add is what is displayed
        add(datePicker);
        add(button);

        //3. To nest components in a specific layout we nest them in that layout as below
        HorizontalLayout layout = new HorizontalLayout(button, datePicker);
        //align to the end
        layout.setDefaultVerticalComponentAlignment(Alignment.END);
        add(layout);

        //3.Add interractivity/ event listener
        button.addClickListener(click -> add(new Paragraph("Clicked: "+ datePicker.getValue() )));

    }
}
