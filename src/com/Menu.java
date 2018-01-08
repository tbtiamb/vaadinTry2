package com;




import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.VerticalLayout;





@SuppressWarnings("serial")

public class Menu extends CustomComponent {



    public Menu() {
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(logoutButton());
        layout.setSizeUndefined();
        layout.setSpacing(true);
        setSizeUndefined();
        //layout.addComponent(canvas);
      //  canvas.setWidth("300px");
       // canvas.setHeight("300px");
        setCompositionRoot(layout);
        StringBuilder script = new StringBuilder();

    }



    private Button logoutButton() {
        Button button = new Button("Logout", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                getUI().getSession().close();
                getUI().getPage().setLocation(getLogoutPath());
            }
        });
        return button;
    }

    private String getLogoutPath() {
        return getUI().getPage().getLocation().getPath();
    }

}