package org.student;

public class Students {
	public void getStudentInfo(int id)
	{System.out.println(" getting sutdent info  using "+id);
		
	}
	public void getStudentInfo(String name)
	{
		System.out.println(" getting sutdent info  using "+name);
		
	}
	public void getStudentInfo(String name, String email)
	{
		System.out.println(" getting sutdent info  using "+name + "mail "+ email);
	}
	public void getStudentInfo(int id, int phone)
	{System.out.println("getting student info using id "+id +"phone "+phone);
		
	}

public static void main(String[] args) {
	
Students stu = new Students();
stu.getStudentInfo(1213);
stu.getStudentInfo("Kashwini)");
stu.getStudentInfo(123, 234556);
stu.getStudentInfo("sharvesh", "asfd@sdf.com");

}
}
