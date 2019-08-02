package pl.krystian.spring.SQL;

import java.sql.*;

public class SQLInput {



    public static boolean SQLLoadInputLogin(String login, String haslo){
        SQLLoad.connect();
        boolean b = querry(login, haslo);
        close();
        return b;
    }




    private static boolean querry(String login, String haslo) {
        try {
            SQLLoad.preparedStatement = SQLLoad.conn.prepareStatement
                    ("INSERT INTO danelogowania (login, haslo) VALUES (?, ?)");
            SQLLoad.preparedStatement.setString(1, login);
            SQLLoad.preparedStatement.setString(2, haslo);
            SQLLoad.preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    private static void close(){
        try {
            SQLLoad.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
