import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[][] map;
	static long[][][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		
		map = new boolean[n][n];
		dp = new long[n][n][3]; // 0 : 가로 / 1 : 세로 / 2 : 대각선
		
		for (int r = 0; r < n; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < n; c++) {
				if (st.nextToken().equals("0")) map[r][c] = true;
			}
		}
		
		dp[0][1][0] = 1;
		
		check();
		
		System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
	}
	
	static void check() {
		
		for (int c = 1; c < n; c++) {
			for (int r = 0; r < n; r++) {
				for (int s = 0; s < 3; s++) {
					if ((s == 0 || s == 2) && c + 1 < n && map[r][c + 1])
						dp[r][c + 1][0] += dp[r][c][s];
					if ((s == 1 || s == 2) && r + 1 < n && map[r + 1][c])
						dp[r + 1][c][1] += dp[r][c][s];
					if (c + 1 < n && r + 1 < n && map[r + 1][c] && map[r][c + 1] && map[r + 1][c + 1])
						dp[r + 1][c + 1][2] += dp[r][c][s];
				}
			}
		}
		
	}
}