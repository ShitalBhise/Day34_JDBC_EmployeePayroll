package com.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
/*
 * create a class name as EmployeePayrollJDBC
 */
public class EmployeePayrollJDBC {
	/*
     * create a main method ,all program execute in main method
     * @param args no arguments, its defaults
     * @throws SQLException
     * @throws ClassNotFoundException
     */
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/payroll_services";
		String uname = "root";
		String password = "Shital27Mysql";
		

		Connection connection = null;
		 /*
         * try catch block is used for exception handling
         * to check if my driver is loaded or not
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// load the driver
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
		listDrivers();
		/* to establish connection with the data base 
         * get connection
         * url, username ,password
         */
		try {
			System.out.println("Connecting to database " + url);
			connection = DriverManager.getConnection(url, uname, password);
			System.out.println("connection is successful!!!!!" + connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
     * create a method name as list driver
     *
     */
	private static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
	}
}
