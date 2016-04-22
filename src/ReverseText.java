import java.util.Scanner;
public class ReverseText {
	public static int counter = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Gi inn streng: ");
		String text = input.nextLine();
		System.out.printf("\nStrengen baklengs: \n");
		reverse(text);
		
		System.out.println("\n");
		System.out.println("Antall tegn: " + counter);
	}
	
	public static void reverse(String text) {
		counter++;
		int length = text.length();
		// Base case
		if(length == 1)
			System.out.print(text);
		
		// Recursive case
		else {
			System.out.print(text.substring(length - 1));
			reverse(text.substring(0, length - 1));
		}
	}
}
