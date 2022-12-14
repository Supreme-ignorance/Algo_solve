import java.io.*;

public class Main {
	static int n;
	static int[] stair;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		stair = new int[n + 1];
		dp = new int[n + 1][2];
		
		for (int i = 1; i < n + 1; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < n + 1; i++) {
			if (i + 1 >= n + 1) continue;
			// 직전 두칸 이동 후 한칸 이동
			dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][1] + stair[i + 1]);
			//첫번째 계단은 다음 칸을 한칸 이동해도 괜찮다
			if (i == 1) dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][0] + stair[i + 1]);
			if (i + 2 >= n + 1) continue;
			// 직전 두칸 이동 후 두칸 이동
			dp[i + 2][1] = Math.max(dp[i + 2][1], dp[i][1] + stair[i + 2]);
			// 직전 한칸 이동 후 두칸 이동
			dp[i + 2][1] = Math.max(dp[i + 2][1], dp[i][0] + stair[i + 2]);
		}

		System.out.println(Math.max(dp[n][0], dp[n][1]));
	}
}