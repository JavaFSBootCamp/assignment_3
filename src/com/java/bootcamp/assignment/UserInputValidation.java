package com.java.bootcamp.assignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UserInputValidation {
	private static User[] userArray = new User[4];
	
	public static void main(String[] args) throws IOException, FileNotFoundException{
		UserData userData = new UserData();
		userArray = userData.getUserData();
		
		UserService userService = new UserService();
		
		Scanner scanner = new Scanner(System.in);
		String userName;
		String password;
		int loginTry=0;
		int totalChance= 5;
		User validUser = null;
		
		while((loginTry < totalChance)) {
			System.out.println("Enter your email: ");
			userName = scanner.nextLine();
			System.out.println("Enter your password: ");
			password= scanner.nextLine();
			
			validUser = userService.validateUser(userName, password, userArray);
			if(validUser != null){
				System.out.println("Welcome: "+ validUser.getName());
				break;
			}
			else
			{
				loginTry++;
				if(loginTry >= totalChance) {
					System.out.println("Too many failed login attempts, you are now locked out.");
				} else
				{
					System.out.println("Invalid login, please try again."+ loginTry);
				}
			}
		}
		scanner.close();
	}

}
