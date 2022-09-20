import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt(); // already have lan cable
		int n = sc.nextInt(); // need lan cable
		
		long[] ahl = new long[k]; // already have lan cable
		long sum = 0;
		
		for (int i = 0; i < k; i++) {
			ahl[i] = sc.nextInt();
			sum += ahl[i];
		}
		
		Arrays.sort(ahl);
		
		long s = 1;
		long e = (long) sum + 1;
		
		while (true) {
			if (s == e || e - s == 1) {
				System.out.println(s);
				break;
			}
			long middle = (s + e) / 2;
			int cnt = 0;
			for (int i = 0; i < k; i++) {
				cnt += ahl[i] / middle;
			}
			
			if (cnt >= n) {
				s = middle;
			}
			else e = middle;
		}
	}
}