package com.java.bootcamp.assignment;

public class UserService {
	
	public User validateUser(String userName, String password, User[] userArray){
		for(User user:userArray) {
			if((user.getUsername().equalsIgnoreCase(userName)) && (user.getPassword().equals(password))) {
				return user;
			}
		}
		return null;
	}
}
