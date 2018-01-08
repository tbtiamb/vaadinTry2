package com;


import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
public class MyVaadinApplication extends UI {

    //@WebServlet(value = {"/*"}, asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinApplication.class)
    public static class Servlet extends VaadinServlet {
    }
    public Navigator navigator;

    public static final String MAINVIEW = "main";


    @Override
    protected void init(VaadinRequest request) {



        final VerticalLayout layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
        ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout);
        navigator = new Navigator(UI.getCurrent(), viewDisplay);
        navigator.addView("", new LoginView());
        navigator.addView(MAINVIEW, new MainView());
    }

}