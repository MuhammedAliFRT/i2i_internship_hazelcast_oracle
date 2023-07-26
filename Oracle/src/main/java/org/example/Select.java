package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select {

    public List<Integer> selectRandomNumbers(int count) {
        List<Integer> randomNumbers = new ArrayList<>();


        String DB_URL = "jdbc:oracle:thin:@localhost:1521:TEST";
        String DB_USERNAME = "system";
        String DB_PASSWORD = "maf";

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");


            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);


            String Select = "SELECT sayi FROM Numbers SAMPLE(" + count + ")";
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(Select);
            while (resultSet.next()) {
                randomNumbers.add(resultSet.getInt("sayi"));
            }


            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return randomNumbers;
    }
}
