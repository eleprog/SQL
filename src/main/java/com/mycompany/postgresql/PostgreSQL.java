package com.mycompany.postgresql;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;


public class PostgreSQL
{   
    public static void main(String[] args) throws IOException
    {   
        // Java code to illustrate reading a
// CSV file line by line
public static void readDataLineByLine(String file)
{

	try {

		File file = new File file();
		FileReader filereader = new FileReader(file);

		// create csvReader object passing
		// file reader as a parameter
		CSVReader csvReader = new CSVReader(filereader);
		String[] nextRecord;

		// we are going to read data line by line
		while ((nextRecord = csvReader.readNext()) != null) {
			for (String cell : nextRecord) {
				System.out.print(cell + "\t");
			}
			System.out.println();
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}

        
        
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
