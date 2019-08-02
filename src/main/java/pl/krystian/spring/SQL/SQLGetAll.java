package pl.krystian.spring.SQL;

import com.vaadin.flow.component.UI;
import pl.krystian.spring.Views.AdminPanelView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLGetAll {
    private static ResultSet rs;
    public static AdminPanelView adminPanelView;

    public static void SQLGet(){
        SQLLoad.connect();
        querry();
        close();
    }



    private static void querry() {
        try {
            SQLLoad.preparedStatement = SQLLoad.conn.prepareStatement("SELECT * FROM sqltestowanie.danelogowania");
            rs = SQLLoad.preparedStatement.executeQuery();

            while(rs.next()){
                AdminPanelView.layout1 = "ID: " + String.valueOf(rs.getInt("IDuser"));
                AdminPanelView.layout2 = "Login: " + rs.getString("login");
                AdminPanelView.layout3 = "Hasło: " +rs.getString("haslo");
                AdminPanelView.layout4 = "Jest adminem?: " + String.valueOf(rs.getBoolean("admin"));
                adminPanelView.addInfo();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void close(){
        try {
            rs.close();
            SQLLoad.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
