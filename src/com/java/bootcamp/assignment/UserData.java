package com.java.bootcamp.assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserData {
	
	public User[] getUserData() throws FileNotFoundException, IOException {
		System.out.println("Opening the file reader to read \"data.txt\" file and extract the data source.");
		User[] userArray = new User[4];
//		System.out.println("Opening File Reader");
		
		BufferedReader fileReader = null;
		try {
			String line;
			int i = 0;
			fileReader = new BufferedReader(new FileReader("data.txt"));
			
			while((line = fileReader.readLine()) != null) {
				User userObject = new User();
				String[] values = line.split(",");
				
				userObject.setUsername(values[0]);
				userObject.setPassword(values[1]);
				userObject.setName(values[2]);
				
				userArray[i] = userObject;
				i++;
			}
		} finally {
			if(fileReader != null) {
				fileReader.close();
			}
//			System.out.println("Closing File Reader");
		}
		System.out.println("Data extracted successfully! Closing file reader.");

		return userArray;
	}

}
