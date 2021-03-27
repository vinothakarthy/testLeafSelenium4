package org.student;

import org.department.Department;

public class Student extends Department {
	public String studentName(String name)
	{
		return name;
	}
	public int studentid(int id)
	{
		return id;
	}public String studentDept( String dept )
	{
		return dept ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student test = new Student();
		test.collegeCode();
		test.collegeName();
		test.collegeCode();
		System.out.println(test.depName("Finance"));
		System.out.println(test.studentName("SHarvesh"));
		System.out.println(test.studentid(324));
		System.out.println(test.studentDept(test.depName("Finance")));
		
		
		

	}

}
