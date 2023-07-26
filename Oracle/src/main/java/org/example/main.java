package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class main {

    public static void main(String[] args){
        int count=100000;

        Insert insert=new Insert();
        long StartInsert=System.currentTimeMillis();
        insert.InsertRandomNumbers(count);
        long EndInsert = System.currentTimeMillis();

        Select select=new Select();
        long StartSelect=System.currentTimeMillis();
        List<Integer> randomNumbers=select.selectRandomNumbers(count);
        long EndSelect = System.currentTimeMillis();

        System.out.println(count+ " Sayı insert time : " +(EndInsert-StartInsert)+"ms");
        System.out.println(count + " Sayı select time : " +(EndSelect-StartSelect)+"ms");



    }

}
