package com.xp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TaskManagment {
	static Connection conn =null;
	static PreparedStatement psmt = null;
	static Scanner sc = new Scanner(System.in);
	static ResultSet rs = null;
	
	
	
	public boolean dbConnect() {
		//step-1- Load and register the driver
		Class.forName("org.sqlite.JDBC");
		System.out.println("Driver Loaded Successfully");
		
		//step-2 -establishing the connection
		String url = "jdbc:sqlite:C:\\Users\\User\\MySQLiteDB";
		
		conn = DriverManager.getConnection(url);
		System.out.println("Database is connected successfully");
		return true;
	}
	public void createTodoTable() {
		String sqlQuery = "Create Table if not exists tasks ("
				+"id integer primary key autoincrement,"
				+"title text not null,"
				+"descriptoin text not null,"
				+"completed boolean not null"
				+");";
		psmt = conn.create
	}
}
