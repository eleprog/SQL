package com.mycompany.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlTerminal implements SqlInterface
{
    private Connection conn;
    private String tableName;
    private int paramAmount = 0;
    
    @Override
    public Connection connect(String url, String username, String password) throws SQLException, Exception
    {
        conn = DriverManager.getConnection(url, username, password);    
        return conn;
    }
                
    @Override
    public boolean createTable(String name, String[] param) throws SQLException, Exception
    {
        paramAmount = param.length;
        tableName = name;
        String sqlBuff = "CREATE TABLE IF NOT EXISTS" ;
        
        for(int i = 0; i < paramAmount - 1; i++)
            sqlBuff += param[i] + ',';
        sqlBuff += param[paramAmount] + ");";
        
        Statement statement = conn.createStatement();
        statement.execute(sqlBuff);
        statement.close();
        
        return true;
    }

    @Override
    public boolean insert(String[] values) {
       
    }

    @Override
    public int insert(String[][] values) {
        
    }

    @Override
    public String[] select(String values) {
       
    }

    @Override
    public void close() throws Exception {
        
    }
    
}
