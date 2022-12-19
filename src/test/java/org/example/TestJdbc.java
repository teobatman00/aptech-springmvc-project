package org.example;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    @Test
    public void testConnectJdbc() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/aptech_springmvc_book?useSSL=false";
        String user = "root";
        String pass = "";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
