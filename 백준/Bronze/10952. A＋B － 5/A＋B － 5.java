import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			while (true) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				if (a == 0 && b == 0)
					break;
				
				System.out.println(a + b);
			}
		} catch (Exception e) {
			return;
		}
	}
}