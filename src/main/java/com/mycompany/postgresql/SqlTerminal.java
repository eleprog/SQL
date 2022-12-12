package com.mycompany.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlTerminal implements SqlInterface
{
    private Connection conn;
    private Statement statement;
    
    void SqlTerminal() {
        
    }
    
    @Override
    public boolean connect(String url, String username, String password) throws SQLException, Exception {
        conn = DriverManager.getConnection(url, username, password);
        statement = conn.createStatement();
        return true;
    }

    @Override
    public boolean create(String tableName, String[] columns) throws SQLException, Exception {
        
        var paramAmount = columns.length;
        var Buff = "CREATE TABLE IF NOT EXISTS " + tableName + "(";
        
        for(int i = 0; i < paramAmount - 1; i++)
            Buff += columns[i] + ',';
        Buff += columns[paramAmount - 1] + ");";
        
        return statement.execute(Buff);
    }

    @Override
    public int insert(String tableName, String columns, String[] values) throws SQLException, Exception {
        String Buff = "INSERT INTO " + tableName + " (" + columns + ")" + " VALUES(";
        for(int i = 0; i < values.length - 1; i++)
            Buff += values[i] + ',';
        Buff += values[values.length - 1] + ");";
        
        System.out.println(Buff);
        
        statement.execute(Buff);
        return 0;
    }

    @Override
    public int updateRows(String tableName, String column, String conditionColumn, String[] conditions, String[] values) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateColumns(String tableName, String[] columns, String[] values, String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[][] select(String[] columns) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteRows(String tableName, String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addColumn(String tableName, String column) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

/*static private Connection conn;
    private Statement statement;
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
        String Buff = "CREATE TABLE IF NOT EXISTS " + name + "(";
        
        for(int i = 0; i < paramAmount - 1; i++)
            Buff += param[i] + ',';
        Buff += param[paramAmount - 1] + ");";
        
        return statement.execute(Buff);
    }

    @Override
    public boolean deleteTable() throws SQLException, Exception {
        return statement.execute("DROP TABLE IF EXISTS " + tableName);
    }
    
    @Override
    public boolean insert(String columns, String[] values) throws SQLException, Exception
    {
        String Buff = "INSERT INTO " + tableName + " (" + columns + ")" + " VALUES(";
        for(int i = 0; i < values.length - 1; i++)
            Buff += values[i] + ',';
        Buff += values[values.length - 1] + ");";
        
        System.out.println(Buff);
        
        statement.execute(Buff);
        return true;        
    }

    @Override
    public int update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /*UPDATE config
    *SET config_value = CASE config_name 
    *                  WHEN 'name1' THEN 'value' 
    *                  WHEN 'name2' THEN 'value2' 
    *                  ELSE config_value
    *                  END
    *WHERE config_name IN('name1', 'name2');
      
    @Override
    public int insert(String columns, String[][] values) throws SQLException, Exception
    {
        //if()
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
    }   */