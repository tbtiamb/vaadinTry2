package com;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import java.io.File;

@SuppressWarnings("serial")
public class LoginView extends VerticalLayout implements View {

    public LoginView() {
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);



        Label label = new Label("Enter your information below to log in.");
        Label labelLaba = new Label("Лабораторная рабоа № 4");
        Label labelNames = new Label("Божик, Егоров, Лысенко");
        TextField username = new TextField("Username");
        TextField password = new TextField("Password");
        String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();

        FileResource resource = new FileResource(new File(basepath +
                "/WEB-INF/images/logo.png"));


        Image image = new Image(null, resource);
        image.setWidth("1020px");
        image.setHeight("210px");


        addComponent(image);
        addComponent(labelLaba);
        addComponent(labelNames);
        addComponent(label);
        addComponent(username);
        addComponent(password);
        HorizontalLayout layout = new HorizontalLayout();
        layout.addComponents(loginButton(),registerButton());
        addComponent(layout);

    }

    @Override
    public void enter(ViewChangeEvent event) {
        Notification.show("Welcome! Please log in.");
    }

    private Button loginButton() {
        Button button = new Button("Log In", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {

                getUI().getNavigator().navigateTo(MyVaadinApplication.MAINVIEW);
            }
        });
        return button;
    }

    private Button registerButton() {
        Button regButton = new Button("Register", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {

            }
        });
        return regButton;
    }

}
