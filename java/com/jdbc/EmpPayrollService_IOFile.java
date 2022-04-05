package com.jdbc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
 * create a class name as EmpPayrollService_IOFile
 */
public class EmpPayrollService_IOFile {
	 /*
     * give the file path where ur file is stored
     */
	public static String PAYROLL_FILE_NAME = "employeePayrollData.txt";

	/*
	 * created a object of string buffer class i.e.empBuffer created Write data
	 */
	public void writeData(List<EmpPayroll_data> employeePayrollList) {
		/*
         * create a object for string buffer class ,object name as empBuffer
         *
         * StringBuffer :-
         *  The principal operations on a StringBuffer are the append and insert methods,
         *   which are overloaded so as to accept data of any type.
         */
		StringBuffer empBuffer = new StringBuffer();
		employeePayrollList.forEach(employee -> {
			String employeeDataString = employee.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* this method is used to Print data
	 *  
	 */
	public void printData() {
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out.println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* This method is used to count entries */
	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}

	/* this is read data method */
	public List<EmpPayroll_data> readData() {
		 /*
         * create a list object name as employeePayrollList
         */
		final List<EmpPayroll_data> employeePayrollList = new ArrayList<EmpPayroll_data>();
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath()).map(line -> line.trim()).forEach(line -> {
				String data = line.toString();
				String[] dataArr = data.split(",");
				for (int i = 0; i < dataArr.length; i++) {
					int id = Integer.parseInt(dataArr[i].replaceAll("id =", ""));
					i++;
					String name = dataArr[i].replaceAll("name =", "");
					i++;
					double salary = Double.parseDouble(dataArr[i].replaceAll("salary =", ""));
					EmpPayroll_data employeePayrollData = new EmpPayroll_data(id, name, salary);
					employeePayrollList.add(employeePayrollData);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
