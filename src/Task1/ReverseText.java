package Task1;
import java.util.Scanner;
public class ReverseText {
	public static int counter = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Gi inn streng: ");
		String text = input.nextLine();
		System.out.printf("\nStrengen baklengs: \n");
		
		try {
		reverse(text);
		System.out.println("\n");
		System.out.println("Antall tegn: " + counter);
		}
		catch (StringIndexOutOfBoundsException ex) {
			System.out.println("----- Ingen streng funnet -----");
		}
	}
	public static void reverse(String text) {
		int last = text.length() - 1;
		reverse(text, last);
	}
	
	public static void reverse(String text, int last) {
		counter++;
		// Base case
		if(last <= 0)
			System.out.print(text.charAt(0));
		
		// Recursive case
		else {
			System.out.print(text.charAt(last));
			reverse(text, last - 1);
		}
	}
}
