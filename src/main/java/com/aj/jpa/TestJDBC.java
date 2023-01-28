package com.aj.jpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.datasource.impl.*;

public class TestJDBC {
    public static void main(String...args) throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@//localhost:1521/XEPDB1"); // jdbc:oracle:thin@//[hostname]:[port]/[DB service name]
        ods.setUser("Scott");
        ods.setPassword("tiger");
        Connection conn = ods.getConnection();

        PreparedStatement stmt = conn.prepareStatement("SELECT 'Hello World!' FROM dual");
        ResultSet rslt = stmt.executeQuery();
        while (rslt.next()) {
            System.out.println(rslt.getString(1));
        }
    }
}
