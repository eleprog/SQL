package com.mycompany.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PostgreSQL
{   
    public static void main(String[] args) 
    {
        Scanner myScnr = new Scanner(System.in);     
        try
        {
            final String name = "shop";
            String[] data = {"id_shop INT", "name VARCHAR(20)"};
            
            SqlTerminal dbTable = new SqlTerminal();
            dbTable.connect("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres");
            System.out.println(dbTable.createTable(name, data));
            
            dbTable.createTable(name, data);
            
            //int a = myScnr.nextInt();
            
            //dbTable.deleteTable();
            //dbTable.close();
        }
        
        
        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
        
        /*try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres"))
        {
            if (conn == null) {
                System.out.println("Failed to make connection!");
                return;
            }
            Statement statement = conn.createStatement();
            
            String sqlBuff = "CREATE TABLE IF NOT EXISTS factory(" +
                                "factory_id serial PRIMARY KEY);";
            statement.execute(sqlBuff);
            
            sqlBuff = "CREATE TABLE IF NOT EXISTS station (" +
                        "station_id int," +
                        "station_name varchar(20) PRIMARY KEY," +
                        "time_open time(0)," +
                        "time_close time(0));";      
            statement.execute(sqlBuff);
            statement.close();
            conn.close();          
        }
        
        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
