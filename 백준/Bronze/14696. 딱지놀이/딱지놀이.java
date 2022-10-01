import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		set : for (int i = 0; i < n; i++) {
			int[] a = new int[5];
			int[] b = new int[5];
			
			int an = sc.nextInt();
			
			for (int j = 0; j < an ; j++) {
				a[sc.nextInt()]++;
			}

			int bn = sc.nextInt();
			
			for (int j = 0; j < bn; j++) {
				b[sc.nextInt()]++;
			}
			
			for (int j = 4; j > 0; j--) {
				if (a[j] > b[j]) {
					System.out.println("A");
					continue set;
				} else if (a[j] < b[j]) {
					System.out.println("B");
					continue set;
				} 
			}
			System.out.println("D");
		}
	}
}