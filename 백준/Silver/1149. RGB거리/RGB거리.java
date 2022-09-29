import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	static int[] prevdp;
	static int[] res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dp = new int[3];
		prevdp = new int[3];
		res = new int[3];
		
		for(int i = 0; i < 3; i++) {
			res[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i ++) {
			prevdp = res;
			res = new int[3];
			
			st = new StringTokenizer(br.readLine());
			
			int[] rgb = new int[3];
			for(int j = 0; j < 3; j++) {
				rgb[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (k == j) dp[k] = Integer.MAX_VALUE;
					else {
						dp[k] = prevdp[j] + rgb[k];
					}
					if (j == 0 || res[k] > dp[k]) res[k] = dp[k];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (min > res[i]) min = res[i];
		}
		
		System.out.println(min);
	}
}