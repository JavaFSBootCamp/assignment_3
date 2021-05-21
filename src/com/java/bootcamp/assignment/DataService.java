package com.java.bootcamp.assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataService {
	
	public User[] getUserData() {
		System.out.println("Opening the file reader to read \"data.txt\" file and extract the data source.");
		User[] userArray = new User[4];
		
		BufferedReader fileReader = null;
		try {
			String line;
			int i = 0;
			fileReader = new BufferedReader(new FileReader("data.txt"));
			
			while((line = fileReader.readLine()) != null) {
				userArray[i] = new User(line.split(","));
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Data extracted successfully! Closing file reader.");

		return userArray;
	}

}
