package com.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Main {
    public static void main(String[] args) {

        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            try {
                String sql = "INSERT INTO students (name, department, age) VALUES (?, ?, ?)";
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "Sumith");
                pstmt.setString(2, "CSE");
                pstmt.setInt(3, 21);

                int rows = pstmt.executeUpdate();
                System.out.println(rows + " record inserted successfully!");
                String query = "SELECT * FROM students";
PreparedStatement selectStmt = conn.prepareStatement(query);

ResultSet rs = selectStmt.executeQuery();

System.out.println("\n--- Student Records ---");

while (rs.next()) {
    System.out.println(
        "ID: " + rs.getInt("id") +
        ", Name: " + rs.getString("name") +
        ", Dept: " + rs.getString("department") +
        ", Age: " + rs.getInt("age")
    );
}


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
