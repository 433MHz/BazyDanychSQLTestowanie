package pl.krystian.spring;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends HorizontalLayout{

    public MainView(){
        VerticalLayout verticalLayout = new VerticalLayout();
        Button button_login_page = new Button("Logowanie");
        Button button_register_page = new Button("Rejestracja");

        button_login_page.addClickListener(buttonClickEvent -> {
            UI.getCurrent().navigate("login_page");
        });

        button_register_page.addClickListener(buttonClickEvent -> {
            UI.getCurrent().navigate("register_page");
        });

        button_login_page.setWidth("300px");
        button_register_page.setWidth("300px");
        verticalLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        verticalLayout.add(button_login_page, button_register_page);
        add(verticalLayout);
    }

}
