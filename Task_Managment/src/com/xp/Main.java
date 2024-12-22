package com.xp;

import java.util.Scanner;

public class Main {

	//user final
	static final String userName = "roushan";
	static final String myPassword = "pass123";
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("===== Welcome to the task managment System===");
		System.out.println("Enter the userName");
		String enteredUserName = sc.nextLine();
		
		if(userName.equals(enteredUserName)) {
			System.out.println("Enter your Password 😊😊 please ");
			String enteredUserPass = sc.nextLine();
			if(myPassword.equalsIgnoreCase(enteredUserPass)) {
				System.out.println("user Login Successful 👍👍");
				
			}
		}

	}

}
