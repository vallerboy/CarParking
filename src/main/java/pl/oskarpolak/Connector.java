package pl.oskarpolak;

import java.sql.*;

/**
 * Created by Lenovo on 28.08.2017.
 */
public  class Connector {
    private static Connector ourInstance = new Connector();

    public static Connector getInstance() {
        return ourInstance;
    }

    private static final String SQL_LINK = "jdbc:mysql://5.135.218.27:3306/oskar";
    private static final String SQL_USER = "oskar";
    private static final String SQL_PASS = "10135886";
    private static final String SQL_CLASS = "com.mysql.jdbc.Driver";


    private Connection connection;


    private Connector() {
        connect();
        System.out.println("Połączono");
    }

    private void connect() {
        try {
            Class.forName(SQL_CLASS).newInstance();
            connection = DriverManager.getConnection(SQL_LINK, SQL_USER, SQL_PASS);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public PreparedStatement getNewPreparedStatement(String sql) {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Statement getNewStatement(){
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
