import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] input = new int[n];
		
		for (int i = 0; i < n; i++) input[i] = sc.nextInt();
		
		int max = 1;
		int inc = 1;
		int dec = 1;
		
		for (int i = 1; i < n; i++) {
			if (input[i-1] > input[i]) {
				dec++;
				inc = 1;
			} else if (input[i-1] < input[i]) {
				inc++;
				dec = 1;
			} else {
				inc++;
				dec++;
			}
			max = Math.max(dec, max);
			max = Math.max(inc, max);
		}
		
		System.out.println(max);
	}
}