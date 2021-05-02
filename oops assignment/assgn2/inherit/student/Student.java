package assgn2.inherit.student;

import assgn2.inherit.department.Department;

public class Student extends Department {
	
	public void studentId(int id)
	{
		System.out.println("Student id is :" + " "  +id);
	}
	public void studentDept(String dept)
	{
		System.out.println("Student Department is :" + " "  +dept);
	}
	
	public void studentName(String name)
	{
		System.out.println("Student Name is :" + " "  +name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student stud=new Student();
		stud.collegeCode();
		stud.collegeName();
		stud.collegeRank();
		stud.deptName();
		
		
		}

	
}
