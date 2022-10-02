import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] hexadecimal = sc.next().toCharArray();
		
		int location = 0;
		int num = 0;
		for (int i = hexadecimal.length - 1; i >= 0; i--) {
			num += hexadecimalToDecimal(hexadecimal[i]) * Math.pow(16, location++);
		}
		
		System.out.println(num);
	}
	
	private static int hexadecimalToDecimal(char hexadecimal) {
		if (hexadecimal == 'A') 
			return 10;
		else if (hexadecimal == 'B')
			return 11;
		else if (hexadecimal == 'C')
			return 12;
		else if (hexadecimal == 'D')
			return 13;
		else if (hexadecimal == 'E')
			return 14;
		else if (hexadecimal == 'F')
			return 15;
		else
			return hexadecimal - '0';
	}
}