import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][][] dp = new int[21][21][21];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			int a, b, c;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			a = Integer.valueOf(st.nextToken());
			b = Integer.valueOf(st.nextToken());
			c = Integer.valueOf(st.nextToken());
			
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
			return dp[i][j][k] = 1;
		}  else if (i < j && j < k) {
			return dp[i][j][k] = W(i, j, k-1) + W(i, j-1, k-1) - W(i, j-1, k);
		} else {
			return dp[i][j][k] = W(i-1, j, k) + W(i-1, j-1, k) + W(i-1, j, k-1) - W(i-1, j-1, k-1);
		}
	}
}