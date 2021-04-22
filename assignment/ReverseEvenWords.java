package week1.day2.assignment;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "I am a working as a tester ";
		String[] split = test.split(" ");
		for (int i = 0; i < split.length; i++) {
			if ((i + 1) % 2 == 0) {
				for (int j = split[i].length() - 1; j >= 0; j--) {
					System.out.print(split[i].charAt(j));
					// rev=rev+split[j];
				}

			} else {
				System.out.print(split[i]);
			}
			System.out.print(" ");

		}

	}
}
