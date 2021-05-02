package assgn2.abstarct.university;

public class College extends University {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		College col = new College();
		col.pg(450);
		col.ug(400);
	}

	@Override
	public void ug(int totugStudents) {
		// TODO Auto-generated method stub
		System.out.println("Print the total no of student " +totugStudents);
	}

}
