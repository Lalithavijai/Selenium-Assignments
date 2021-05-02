package assgn1.abstarct.computer;

public class Desktop implements Hardware,Software{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Desktop dt=new Desktop();
		dt.hardwareResources();
		dt.softwareResources();

	}

	public void softwareResources() {
		// TODO Auto-generated method stub
		
		System.out.println("Software resources required are OS etc");
		
	}

	public void hardwareResources() {
		// TODO Auto-generated method stub
		System.out.println("Hardware resources required are mouse, keyboard,printer etc");
	}

}
