package com.vaadincrm.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation to make the application installable on phones, tablets,
 * and some desktop browsers.
 *
 */
@Theme(value = "vaadin.app")
@SpringBootApplication
@ComponentScan(basePackages = {
    "com.vaadincrm.application.backend.repository",
    "com.vaadincrm.application.backend.service",
    "com.vaadincrm.application.ui" // Add the package of MainView and other UI components
})
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
