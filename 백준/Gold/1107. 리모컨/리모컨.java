import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] buttons = new boolean[10];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int n = Integer.valueOf(input);
		int m = Integer.valueOf(br.readLine());
		
		Arrays.fill(buttons, true);
		
		if (m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < m; i++) {
				int temp = Integer.valueOf(st.nextToken());
				buttons[temp] = false;
			}
		}
		
		int res = Math.abs(100 - n);

		up : for (int i = n; i >= 0; i++) {
			
			int j = 0;
			
			while (true) {
				int temp = (int) Math.pow(10, j + 1);
				int digit = (int) Math.pow(10, j);
				
				if (i - n > res) {
					break up;
				}
				
				if (i % digit == i && j != 0) {
					int upmin = j + i - n;
					res = Math.min(res, upmin);
					break up;
				}
					
				int quotient = (i % temp) / digit;
				
				if (!buttons[quotient]) {
					continue up;
				}
				
				j++;
			}
		}
		
		down : for (int i = n; i >= 0; i--) {
			
			int j = 0;
			
			while (true) {
				int temp = (int) Math.pow(10, j + 1);
				int digit = (int) Math.pow(10, j);
				
				if (n - i > res) {
					break down;
				}
				
				if (i % digit == i && j != 0) {
					int downmin = j + n - i;
					res = Math.min(res, downmin);
					break down;
				}
				
				int quotient = (i % temp) / digit;
				
				if (!buttons[quotient]) {
					continue down;
				}
				
				j++;
			}
		}
		
		System.out.println(res);
	}
}