package com.selekode.armagrid.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.OutputStream;
import java.io.FileOutputStream;


public class DatabaseConnection {
	public static Connection connect() {
		try {
			// Load file from classpath (inside src/main/resources/database)
			InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("database/armagridDB.db");

			if (input == null) {
				throw new FileNotFoundException("Database file not found in resources.");
			}

			// Create a temporary file to hold the database
			File tempFile = File.createTempFile("armagridDB", ".db");
			tempFile.deleteOnExit(); // Clean up on exit

			// Copy content to temp file
			try (OutputStream out = new FileOutputStream(tempFile)) {
				input.transferTo(out);
			}

			// Get JDBC connection using the temp file path
			String url = "jdbc:sqlite:" + tempFile.getAbsolutePath();
			return DriverManager.getConnection(url);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
