package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class Insert {
    public void InsertRandomNumbers(int count){
        String DB_URL = "jdbc:oracle:thin:@localhost:1521:TEST";
        String DB_USERNAME = "system";
        String DB_PASSWORD = "maf";
        try{

            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String InsertQuery = "INSERT INTO Numbers (Id) VALUES (TRUNC(DBMS_RANDOM.VALUE(1, 1000000)))";
            PreparedStatement preparedStatement = connection.prepareStatement(InsertQuery);
            for(int i=0;i<count;i++){
                int RandomNumbers=(int) Math.random();
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
