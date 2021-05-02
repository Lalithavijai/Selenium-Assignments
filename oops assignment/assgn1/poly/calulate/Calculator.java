package assgn1.poly.calulate;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator calculate=new Calculator();
		calculate.add(100, 200);
		calculate.add(34, 90, 700);
		calculate.multi(25, 26);
		calculate.multi(23, 23.5);
		calculate.sub(34, 35);
		calculate.sub(340.5, 300);
		calculate.div(20, 35);
		calculate.div(40.5, 30);
	}

	public void add(int num1,int num2) 
	{
		System.out.println("Addition of two int nos :" +num1+num2);
	}
	public void add(int num1,int num2,int num3) 
	{
		System.out.println("Addition of three int nos :" +num1+num2+num3);
	}
	public void multi(int num1,int num2) 
	{
		System.out.println("Product of two int nos :" +num1*num2);
	}
	
	public void multi(int num1,double num2) 
	{
		System.out.println("Product of two nos :" +num1*num2);
	}
	
	public void sub(int num1,int num2) 
	{
		System.out.println("Subtraction of two int nos :" +(num1-num2));
	}
	
	public void sub(double num1,double num2) 
	{
		System.out.println("Subtraction of two int nos :" +(num1-num2));
	}
	public void div(double num1,int num2) 
	{
		System.out.println("Division of two nos :" +(num1/num2));
	}
	
	public void div(int num1,int num2) 
	{
		System.out.println("Division of two int nos :" +(num1/num2));
	}
}
