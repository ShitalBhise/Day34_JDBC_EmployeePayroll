package com.jdbc;

import java.time.LocalDate;
/*
 * create class name as EmpPayroll_data
 */
public class EmpPayroll_data {
	 /*
     * variables
     */
	public int id;
	public String name;
	public double salary;
	public LocalDate startDate;

	/*
     * create a constructor
     * @param id- employee id
     * @param departmentId - employee department id
     */
	public EmpPayroll_data(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public EmpPayroll_data(int id, String name, double salary, LocalDate startDate) {
		/*
         * The this keyword is used to refer to the current object.
         */
		this(id, name, salary);
		this.startDate = startDate;
	}

	/* Created to string Method to print data */
	@Override
	public String toString() {
		return "EmployeePayrollData [id=" + id + ", name=" + name + ", salary=" + salary + ", startDate=" + startDate
				+ "]";
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass())
			return false;
		EmpPayroll_data that = (EmpPayroll_data) object;
		return id == that.id && Double.compare(that.id, id) == 0 && name.equals(that.name);
	}
}
