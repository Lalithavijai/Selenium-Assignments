package assgn3.inherit.bank;

public class AxisBank extends BankInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AxisBank ax=new AxisBank();
		ax.fixed(100000);
		ax.saving(50000);
		ax.deposit();
		
}
public void deposit()
{
	System.out.println("The deposit amount is 10000000");
}
}
