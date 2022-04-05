package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;
/*
 * create class EmpPayroll_DB
 */
public class EmpPayroll_DB {
	/* 
	 * This method is used to get connection 
	 
	 */
	private Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/payroll_services";
		String uname = "root";
		String password = "Shital27Mysql";
		Connection connection = null;
		System.out.println("Connecting to database " + url);
		try {
			connection = DriverManager.getConnection(url, uname, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("connection is successful!!!!!" + connection);
		return connection;
	}

	public List<EmpPayroll_data> readData() {
		String sql = "select * from employee_payroll";
		List<EmpPayroll_data> employeePayrollList = new ArrayList<EmpPayroll_data>();
		try (Connection connection = this.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double salary = resultSet.getDouble("salary");
				LocalDate startDate = resultSet.getDate("startDate").toLocalDate();
				EmpPayroll_data employeePayrollData = new EmpPayroll_data(id, name, salary, startDate);
				employeePayrollList.add(employeePayrollData);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}
}
