import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] woman = new int[7];
		int[] man = new int[7];
		
		for (int i = 0; i < n; i++) {
			int g = sc.nextInt();
			
			switch (g) {
			case 0 :
				woman[sc.nextInt()]++;
				break;
			case 1 :
				man[sc.nextInt()]++;
				break;
			}
		}
		
		int needRoom = 0;
		
		for (int i = 1; i < 7; i++) {
			needRoom += woman[i] / k;
			if (woman[i] % k != 0) needRoom++;
			needRoom += man[i] / k;
			if (man[i] % k != 0) needRoom++;
		}
		
		System.out.println(needRoom);
	}
}