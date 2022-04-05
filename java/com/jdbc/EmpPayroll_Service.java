package com.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * UC1 :- Ability to create a payroll service database and have java program connect to database
 * UC2 :- Ability for Employee Payroll Service to retrieve the Employee Payroll from the Database
 * UC3 :- Ability to update the salary i.e. the base pay for Employee Terisa to 3000000.00 and sync it with Database
 * UC4 :- Ability to update the salary i.e. the base pay for Employee Terisa to 3000000.00 and sync it with Database
 *        using JDBC PreparedStatement
 * UC5 :- Ability to retrieve all employees who have joined in a particular data range from the payroll service database
 * UC6 :- Ability to find sum, average, min,max and number of male and female employees
 * UC7 :- Ability to add a new Employee to the Payroll
 * UC8 :- Ability to also add to payroll details when a new Employee is added to the Payroll
 * UC9 :- Implement the complete ER Diagram in the Database
 * UC10 :- Ensure UC 2 – UC 7  works with the new ER Diagram implemented into Payroll Service DB
 * UC11 :- Ability to add a new Employee to the Payroll
 * UC12 :- Ability to remove Employee from the Payroll
 *
 */

/*
 * create a class name as EmpPayroll_Service
 */
public class EmpPayroll_Service {
	/*
     * creating a enum class.
     * Enums can be thought of as classes which have a fixed set of constants (a variable that does not change).
     * The enum constants are static and final implicitly
     */
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	public static final String IOSevice = null;

	public List<EmpPayroll_data> employeePayrollList;

	public EmpPayroll_Service() {
		// TODO Auto-generated constructor stub
	}

	public EmpPayroll_Service(List<EmpPayroll_data> employeePayrollList) {
		// TODO Auto-generated constructor stub
		this.employeePayrollList = employeePayrollList;
	}
	 /*
     * create a method name as readEmployeeData
     * @param consoleInputReader
     */
	public void readEmployeeData(Scanner consoleInputReader) {
		/*
         * Log an INFO message.
         * If the logger is currently enabled for the INFO message
         * level then the given message is forwarded to all the registered output Handler objects.
         */
		System.out.println("Enter employee ID : ");
		int id = Integer.parseInt(consoleInputReader.nextLine());
		System.out.println("Enter employee name : ");
		String name = consoleInputReader.nextLine();
		System.out.println("Enter employee salary : ");
		double salary = Double.parseDouble(consoleInputReader.nextLine());
		employeePayrollList.add(new EmpPayroll_data(id, name, salary));
	}
	/*
     * create a method name as readPayrollDataForRange
     * this is parameterized method
     * @param ioService
     * @param startDate
     * @param endDate
     * @return
     */
	public List<EmpPayroll_data> readEmployeepayrollData(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			return new EmpPayrollService_IOFile().readData();
		else if (ioService.equals(IOService.DB_IO))
			return new EmpPayroll_DB().readData();
		else
			return null;
	}
	/*
     * create a method name as writeEmployeeData
     * @param ioService
     */
	public void writeEmployeeData(IOService ioService) {
		if (ioService.equals(IOService.CONSOLE_IO))
			System.out.println("\nWriting Employee Payroll Roster to Console\n" + employeePayrollList);
		else if (ioService.equals(IOService.FILE_IO))
			new EmpPayrollService_IOFile().writeData(employeePayrollList);
	}
	/*
     * create a method name as printData,
     * this is parameterized method
     * @param ioService
     */
	public void printData(IOService ioService) {
		new EmpPayrollService_IOFile().printData();
	}
	 /*
     * create  a method name as countEntries,the method type is long
     * @param ioService
     * @return enteries
     */
	public long countEntries(IOService iOService) {
		// TODO Auto-generated method stub
		if (iOService.equals(IOService.FILE_IO))
			return new EmpPayrollService_IOFile().countEntries();
		return 0;
	}

	public static void main(String[] args) {
		 /*
         * create a list object name as  employeePayrollList
         * here EmployeePayrollData is a class.
         */
		System.out.println("Welcome To Employee Payroll Application\n");
		List<EmpPayroll_data> employeePayrollList = new ArrayList<EmpPayroll_data>();
		/*
         * create a object for  EmployeePayrollService class ,object name as employeePayrollService
         */
		EmpPayroll_Service employeePayrollService = new EmpPayroll_Service(employeePayrollList);
		 /*
         * create a scanner class object name as object is consoleInputReader
         */
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeeData(consoleInputReader);
		/*
         * calling writeEmployeeData method from employeePayrollService object
         */
		employeePayrollService.writeEmployeeData(IOService.CONSOLE_IO);
	}
}
