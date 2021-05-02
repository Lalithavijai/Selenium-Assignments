package assgn4.inherit.students;

public class Students {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Students studs=new Students();
		studs.getStudentInfo("Sairam", 149);
		studs.getStudentContact("sai@gmail.com", 9176288355l);

	}
	
	public void getStudentInfo(String name, int id)
	
	{
		System.out.println("Student name is :" +name +"Student id is :" +id);
	}
public void getStudentContact(String email, long mobile)
	
	{
		System.out.println("Student email id is :" +email +"Student mobile number is :" +mobile);
	}
}

