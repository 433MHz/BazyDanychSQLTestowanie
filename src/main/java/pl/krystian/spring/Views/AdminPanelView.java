package pl.krystian.spring.Views;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import pl.krystian.spring.SQL.SQLGetAll;


@Route("admin_panel")
public class AdminPanelView extends HorizontalLayout {
    VerticalLayout verticalLayout1 = new VerticalLayout();
    VerticalLayout verticalLayout2 = new VerticalLayout();
    VerticalLayout verticalLayout3 = new VerticalLayout();
    VerticalLayout verticalLayout4 = new VerticalLayout();

    public static String layout1;
    public static String layout2;
    public static String layout3;
    public static String layout4;

    int i;

    public AdminPanelView(){
        SQLGetAll.adminPanelView = this;
        SQLGetAll.SQLGet();
        }

        public void addInfo(){


            Label label1 = new Label(layout1);
            Label label2 = new Label(layout2);
            Label label3 = new Label(layout3);
            Label label4 = new Label(layout4);
            Label labelEmpty = new Label("");

            switch (i){
                case 1:
                    verticalLayout1.add(label1, label2, label3, label4, labelEmpty);
                    break;

                case 2:
                    verticalLayout2.add(label1, label2, label3, label4, labelEmpty);
                    break;

                case 3:
                    verticalLayout3.add(label1, label2, label3, label4, labelEmpty);
                    break;

                case 4:
                    verticalLayout4.add(label1, label2, label3, label4, labelEmpty);
                    break;
            }




            add(verticalLayout1, verticalLayout2, verticalLayout3, verticalLayout4);
            if(i == 4){
                i=1;
            }
            i++;
        }
    }

