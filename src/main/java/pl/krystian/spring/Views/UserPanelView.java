package pl.krystian.spring.Views;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("user_panel")
public class UserPanelView extends HorizontalLayout {
    public UserPanelView(){
        Label label = new Label("User panel");
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        add(label);
    }
}
