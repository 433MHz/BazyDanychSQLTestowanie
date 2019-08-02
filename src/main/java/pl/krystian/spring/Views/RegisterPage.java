package pl.krystian.spring.Views;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;
import pl.krystian.spring.SQL.SQLInput;
import pl.krystian.spring.SQL.SQLLoad;
import pl.krystian.spring.Views.LoginView;

@Route("register_page")
public class RegisterPage extends LoginView {
    PasswordField passwordFieldCheck = new PasswordField("Potwierdź hasło");

    public RegisterPage(){
        current = false;
        label.setText("Rejestracja");
        buttonLogin.setText("Zarejestruj");
        buttonLogin.addClickListener(buttonClickEvent -> {

            if(SQLLoad.SQLLoadLogin(textFieldLogin.getValue())){
                Notification notification = new Notification("Login jest już zajęty", 3000, Notification.Position.TOP_CENTER);
                notification.open();
            }
            else
            {
                String login = textFieldLogin.getValue();
                String haslo = passwordField.getValue();
                String hasloCheck = passwordFieldCheck.getValue();

                if(login.length() >= 6 && login.length() <= 24 && haslo.length() >= 6 &&
                haslo.length() <=24 && haslo.equals(hasloCheck)){
                    if(SQLInput.SQLLoadInputLogin(login, haslo)){
                        Notification notification = new Notification("Zarejestrowano pomyślnie!", 5000, Notification.Position.TOP_CENTER);
                        notification.open();
                        textFieldLogin.clear();
                        passwordField.clear();
                        passwordFieldCheck.clear();
                    }
                }
                else{
                    Notification notification = new Notification("Błąd logowania! Upewnij się czy hasła są takie same lub czy login oraz hasło mają od 6 do 24 znaków",
                            6000, Notification.Position.TOP_CENTER);
                    notification.open();
                }
            }
        });

        verticalLayout.add(label, textFieldLogin, passwordField, passwordFieldCheck, buttonLogin, buttonMainPage);
    }
}
