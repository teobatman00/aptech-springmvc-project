package org.example;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    @Test
    public void testConnectJdbc() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/C2007_C2011_ebook?useSSL=false";
        String user = "root";
        String pass = "ab123456..";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
