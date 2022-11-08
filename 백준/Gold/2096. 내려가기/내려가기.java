import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int dp[][] = new int[2][6];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dp[0][0] = Integer.valueOf(st.nextToken());
		dp[0][1] = Integer.valueOf(st.nextToken());
		dp[0][2] = Integer.valueOf(st.nextToken());
		dp[0][3] = dp[0][0];
		dp[0][4] = dp[0][1];
		dp[0][5] = dp[0][2];
		
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int[] temp = new int[3];
			
			temp[0] = Integer.valueOf(st.nextToken());
			temp[1] = Integer.valueOf(st.nextToken());
			temp[2] = Integer.valueOf(st.nextToken());
			
			dp[1][0] = Math.max(dp[0][0], dp[0][1]) + temp[0];
			dp[1][1] = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2])) + temp[1];
			dp[1][2] = Math.max(dp[0][1], dp[0][2]) + temp[2];
			dp[1][3] = Math.min(dp[0][3], dp[0][4]) + temp[0];
			dp[1][4] = Math.min(dp[0][3], Math.min(dp[0][4], dp[0][5])) + temp[1];
			dp[1][5] = Math.min(dp[0][4], dp[0][5]) + temp[2];
			
			dp[0] = dp[1];
			dp[1] = new int[6];
		}
		
		System.out.println(Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2])) + " " + Math.min(dp[0][3], Math.min(dp[0][4], dp[0][5])));
	}
}