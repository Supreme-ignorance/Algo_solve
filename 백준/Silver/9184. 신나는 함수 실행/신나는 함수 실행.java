import java.util.Scanner;

public class Main {
	static int[][][] dp = new int[21][21][21];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int a, b, c;
			
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			if (a == -1 && b == -1 && c == -1) break;
			
			int res;
			
			if (a <= 0 || b <= 0 || c <= 0) {
				res = 1;
			} else if (a > 20 || b > 20 || c > 20) {
				res = W(20, 20, 20);				
			} else {
				res = W(a, b, c);				
			}
			
			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, res);
		}
	}
	
	static int W(int i, int j, int k) {
		if (dp[i][j][k] != 0) return dp[i][j][k];
		
		if (i <= 0 || j <= 0 || k <= 0) {
			dp[i][j][k] = 1;
		}  else if (i < j && j < k) {
			dp[i][j][k] = W(i, j, k-1) + W(i, j-1, k-1) - W(i, j-1, k);
		} else {
			dp[i][j][k] = W(i-1, j, k) + W(i-1, j-1, k) + W(i-1, j, k-1) - W(i-1, j-1, k-1);
		}
		return dp[i][j][k];
	}
}