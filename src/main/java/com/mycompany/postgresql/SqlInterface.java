package com.mycompany.postgresql;

import java.sql.Connection;
import java.sql.SQLException;

public interface SqlInterface extends AutoCloseable
{
    Connection connect(String url, String username, String password) throws SQLException, Exception;
    
    boolean createTable(String name, String[] param) throws SQLException, Exception;
    
    boolean insert(String[] values);
    
    int insert(String[][] values);
    
    String[] select(String values);
    
}
