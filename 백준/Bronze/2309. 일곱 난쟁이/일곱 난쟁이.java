import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean result = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dwarfs = new int[9];
		
		for (int i = 0; i < dwarfs.length; i++) {
			dwarfs[i] = sc.nextInt();
		}
		
		Arrays.sort(dwarfs);
		
		boolean[] check = new boolean[9];
		
		seven(dwarfs, check, 0, 7);
	}
	
	static void seven(int[] dwarfs, boolean[] check, int s, int r) {
		if (result) return;
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < dwarfs.length; i++) {
				if(check[i]) sum += dwarfs[i];
			}
			
			if (sum != 100) return;
				
			for (int i = 0; i < dwarfs.length; i++) {
				if(check[i]) System.out.println(dwarfs[i]);
			}
			result = true;
			return;
		}
		
		for (int i = s; i < dwarfs.length; i++) {
			check[i] = true;
			seven(dwarfs, check, i + 1, r - 1);
	        check[i] = false;
	    }
	}
}