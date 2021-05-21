package com.java.bootcamp.assignment;

import java.util.Scanner;

public class UserApplication {
	
	public static void main(String[] args){
		User[] userArray = new User[4];
		DataService userData = new DataService();
		userArray = userData.getUserData();
		
		UserService userService = new UserService();
		
		Scanner scanner = new Scanner(System.in);
		String userName;
		String password;
		
		int loginAttempt=0;
		User isValidUser = null;
		
		while((loginAttempt < 5)) {
			System.out.println("Enter your email: ");
			userName = scanner.nextLine();
			System.out.println("Enter your password: ");
			password= scanner.nextLine();
			
			isValidUser = userService.validateUser(userName, password, userArray);
			if(isValidUser != null){
				System.out.println("Welcome: "+ isValidUser.getName());
				break;
			}
			else
			{
				loginAttempt++;
				if(loginAttempt >= 5) {
					System.out.println("Too many failed login attempts, you are now locked out.");
				} else
				{
					System.out.println("Invalid login, please try again." + loginAttempt);
				}
			}
		}
		scanner.close();
	}

}
