package com.mycompany.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlTerminal implements SqlInterface
{
    private Connection conn;
    private Statement statement;
    private boolean printConsoleFlag = true;
    
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
        int maxIndexParam = columns.length - 1;
        String Buff = "CREATE TABLE IF NOT EXISTS " + tableName + " (";
        
        for(int i = 0; i < maxIndexParam; i++)
            Buff += columns[i] + ", ";
        Buff += columns[maxIndexParam] + ");";
        
        if(printConsoleFlag) System.out.println(Buff);
        
        return statement.execute(Buff);
    }

    @Override
    public boolean create(String tableName, String[][] columns) throws SQLException, Exception {
        int maxIndexParam = columns.length - 1;
        String Buff = "CREATE TABLE IF NOT EXISTS " + tableName + " (";
        
        for(int i = 0; i < maxIndexParam; i++){
            Buff += columns[i][0] + " ";
            Buff += columns[i][1] + " ";
            Buff += columns[i][2] + ", ";
        }
        
        Buff += columns[maxIndexParam] + ");";
        
        if(printConsoleFlag) System.out.println(Buff);
        
        return statement.execute(Buff);
    }
    
    @Override
    public int insert(String tableName, String columns, String[] values) throws SQLException, Exception {
        String Buff = "INSERT INTO " + tableName + " (" + columns + ")" + " VALUES(";
        for(int i = 0; i < values.length - 1; i++)
            Buff += values[i] + ',';
        Buff += values[values.length - 1] + ");";
        
        if(printConsoleFlag) System.out.println(Buff);
        
        statement.execute(Buff);
        return 0;
    }

    @Override
    public int insert(String tableName, String[] values) throws SQLException, Exception {
        int maxIndexParam = values.length - 1;
        String Buff = "INSERT INTO " + tableName + " VALUES (";
        
        for(int i = 0; i < maxIndexParam; i++)
            Buff += values[i] + ',';
        Buff += values[maxIndexParam] + ");";
        
        if(printConsoleFlag) System.out.println(Buff);
        
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
        statement.close();
        conn.close();      
    }
}
    /*  UPDATE config
    *   SET config_value = CASE config_name 
    *                      WHEN 'name1' THEN 'value' 
    *                      WHEN 'name2' THEN 'value2' 
    *                      ELSE config_value
    *                      END
    *   WHERE config_name IN('name1', 'name2');
    */
