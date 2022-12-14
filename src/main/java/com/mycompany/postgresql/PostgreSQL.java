package com.mycompany.postgresql;

import java.io.IOException;
import java.sql.SQLException;


public class PostgreSQL
{   
    public static void main(String[] args) throws IOException 
    {    
        final String name = "shop";
        String[] data = {"id_shop INT", "name VARCHAR(20)"};
        
        try (SqlTerminal dbTable = new SqlTerminal()) {
            dbTable.connect("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres");
            dbTable.create(name, data);

            String[] insert = {"1","'hello'"};
            dbTable.insert(name, insert);
        }
           
        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
