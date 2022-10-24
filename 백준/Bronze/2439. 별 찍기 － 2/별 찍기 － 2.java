import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > i; j--) {
				sb.append(" ");
			}
			for (int j = 0; j <= i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}