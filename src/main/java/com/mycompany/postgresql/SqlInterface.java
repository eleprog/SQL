package com.mycompany.postgresql;

import java.sql.Connection;
import java.sql.SQLException;

public interface SqlInterface extends AutoCloseable
{
    boolean connect(String url, String username, String password) throws SQLException, Exception;
    
    boolean createTable(String name, String[] param) throws SQLException, Exception;
    
    boolean deleteTable() throws SQLException, Exception;
    
    boolean insert(String columns, String[] values) throws SQLException, Exception;
    
    int insert(String columns, String[][] values) throws SQLException, Exception;
    
    int update();
    
    String[] select(String values);
}
