import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int[][] items;
	static long[] dp;
	static int maxVal = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		
		items = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.valueOf(st.nextToken());
			items[i][1] = Integer.valueOf(st.nextToken());
		}
		
		dp = new long[k + 1];

		for (int i = 0; i < n; i++) {
			for (int j = k; j >= items[i][0]; j--) {
				dp[j] = Math.max(dp[j], dp[j - items[i][0]] + items[i][1]);
			}
		}

		System.out.println(dp[k]);
	}
}