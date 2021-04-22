package week1.day2.assignment;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "You are so sweet and you look like my cousin";
		String[] split = input.split(" ");
//int count=0;
		for (int i = 0; i < split.length; i++) {
			for (int j = i + 1; j < split.length - 1; j++) {
				if (split[i].equalsIgnoreCase(split[j])) {
					// count=count+1;
					// if(count>1)
					split[j] = "";

				}

			}
			System.out.print(split[i] + " ");

		}

	}

}