package pl.krystian.spring.SQL;

import com.vaadin.flow.component.UI;

import java.sql.*;

public class SQLLogin {
    private static ResultSet rs;

    public static boolean SQLLoginCheck(String login, String haslo){
        SQLLoad.connect();
        boolean aBoolean = querry(login, haslo);
        close();
        return aBoolean;
    }



    private static boolean querry(String login, String haslo) {
        try {
            SQLLoad.preparedStatement = SQLLoad.conn.prepareStatement("SELECT * FROM sqltestowanie.danelogowania WHERE login = ? AND haslo = ?");
            SQLLoad.preparedStatement.setString(1, login);
            SQLLoad.preparedStatement.setString(2, haslo);
            rs = SQLLoad.preparedStatement.executeQuery();

            if(rs.next()){
                if(rs.getBoolean("admin")){
                    UI.getCurrent().navigate("admin_panel");
                }
                else{
                    UI.getCurrent().navigate("user_panel");
                }
                return true;
            }
            else{

                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
