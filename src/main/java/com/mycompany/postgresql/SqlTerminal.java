package com.mycompany.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlTerminal implements SqlInterface
{
    private Statement statement;
    private Connection conn;
    private String tableName;
    private int paramAmount = 0;
    
    void SqlTerminal() {
        
    }
    
    @Override
    public boolean connect(String url, String username, String password) throws SQLException, Exception
    {
        conn = DriverManager.getConnection(url, username, password);
        statement = conn.createStatement();
        return true;
    }
                
    @Override
    public boolean createTable(String name, String[] param) throws SQLException, Exception
    {
        paramAmount = param.length;
        tableName = name;
        String sqlBuff = "CREATE TABLE IF NOT EXISTS " + name + "(";
        
        for(int i = 0; i < paramAmount - 1; i++)
            sqlBuff += param[i] + ',';
        sqlBuff += param[paramAmount - 1] + ");";
            
        return statement.execute(sqlBuff);  
    }

    @Override
    public boolean insert(String[] values) {
         
        return false;
         
    }

    @Override
    public int insert(String[][] values) {
        
        return 0;
        
    }

    @Override
    public String[] select(String values) {
       
        return null;
       
    }

    @Override
    public void close() throws Exception {
         statement.close();
         conn.close();
    }
    
}
