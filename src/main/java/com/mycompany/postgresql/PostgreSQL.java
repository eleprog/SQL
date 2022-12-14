package com.mycompany.postgresql;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class PostgreSQL
{   
    public static void main(String[] args) throws IOException
    {   
        ArrayList dataCSV = new ArrayList<String[]>();
        String[] nextRecord;

	try {
            File file = new File("opisanie_poley.csv");
            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReader(filereader);

            for(int i = 0; (nextRecord = csvReader.readNext()) != null; i++)
                dataCSV.add(nextRecord);
            
	}
	catch (CsvValidationException | IOException e) {
		e.printStackTrace();
	}
        
        
     
        final String name = "shop"; 
        SqlTerminal dbTable = new SqlTerminal();
        
        try {   
            dbTable.connect("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres");
            dbTable.create(name, dataCSV);
            
            dbTable.close();
        }
           
        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
