package pl.krystian.spring.Views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.krystian.spring.SQL.SQLLogin;;

@Route("login_page")
public class LoginView extends HorizontalLayout {
    VerticalLayout verticalLayout = new VerticalLayout();
    Label label = new Label("Logowanie");
    TextField textFieldLogin = new TextField("Login");
    PasswordField passwordField = new PasswordField("Hasło");
    Button buttonLogin = new Button("Zaloguj się");
    Button buttonMainPage = new Button("Strona główna");
    boolean current = true;




    public LoginView(){

        buttonLogin.addClickListener(buttonClickEvent -> {
            if(current == true) {
                if (SQLLogin.SQLLoginCheck(textFieldLogin.getValue(), passwordField.getValue())) {
                    Notification notification = new Notification("Zalogowano pomyślnie", 3000, Notification.Position.TOP_CENTER);
                    notification.open();
                } else {
                    Notification notification = new Notification("Błędne dane logowania", 3000, Notification.Position.TOP_CENTER);
                    notification.open();
                }
            }
        });



        buttonMainPage.addClickListener(buttonClickEvent -> {
            UI.getCurrent().navigate("");
        });



        buttonLogin.setWidth("300px");
        buttonMainPage.setWidth("300px");

        verticalLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        verticalLayout.add(label,textFieldLogin, passwordField, buttonLogin, buttonMainPage);
        add(verticalLayout);
    }
}
