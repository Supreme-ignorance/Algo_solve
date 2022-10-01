import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] list = new int[n][2];
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < 2; c++) {
				list[r][c] = sc.nextInt();
			}
		}
		
		Arrays.sort(list, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
		
		for(int r = 0; r < n; r++) {
				System.out.println(list[r][0] + " " + list[r][1]);
		}
	}
}