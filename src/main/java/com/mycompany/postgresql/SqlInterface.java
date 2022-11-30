package com.mycompany.postgresql;

import java.sql.Connection;


public interface SqlInterface extends AutoCloseable
{
    Connection connect(String url, String username, String password);
    
    boolean createTable(String name, String[] param);
    
    boolean Insert(String name, String[] values);
    
    int Insert(String name, String[][] values);
    
    String[] select(String name, String values);
}
