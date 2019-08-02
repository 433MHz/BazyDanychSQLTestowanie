package pl.krystian.spring.SQL;

import java.sql.*;

public class SQLLoad {
    public static Connection conn;
    public static PreparedStatement preparedStatement;
    public static ResultSet rs;

    public static boolean SQLLoadLogin(String login){
        connect();
        boolean aBoolean = querry(login);
        close();
        return aBoolean;
    }

    public static void connect(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltestowanie", "krystian", "1234");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    private static boolean querry(String login) {
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM sqltestowanie.danelogowania WHERE login = ?");
            preparedStatement.setString(1, login);
            rs = preparedStatement.executeQuery();

            if(rs.next()){
                return true;
            }
            else{

                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return true;
    }

    private static void close(){
        try {
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
