import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int[] dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dp[0] = Integer.valueOf(st.nextToken());
		int max = dp[0];
		
		for (int i = 1; i < n; i++) {
			dp[i] = Integer.valueOf(st.nextToken());
			dp[i] = Math.max(dp[i], dp[i] + dp[i - 1]);
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
	}
}