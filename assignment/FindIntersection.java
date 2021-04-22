package week1.day2.assignment;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a[]= {3,2,7,8,9,11};
int b[]= {4,1,8,9,11};
for (int i = 0; i < a.length; i++) {
	for (int j = 1; j < b.length; j++) {
		if(a[i]==b[j])
		{
		System.out.print(a[i] +" ");
	}
	
}

	}

	}
}
