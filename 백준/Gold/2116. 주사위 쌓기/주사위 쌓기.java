import java.util.*;

public class Main {
	
	static int[][] dice;
	static int[] top;
	static int n;
	static int[][] except = { {0, 5}, {1, 3}, {2, 4}, {3, 1}, {4, 2}, {5, 0} };
	static int ans = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		dice = new int[n][6];
		
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < 6; j++) {
				dice[i][j] = sc.nextInt();
			}
		}
		
		dicestack(-1, 0, 0);
		
		System.out.println(ans);
	}
	
	static void dicestack (int prevtopidx, int size, int sum) {
		if (size == n) {
			ans = Math.max(sum, ans);
			return;
		} else if (size == 0) {
			for (int i = 0; i < 6; i++) {
				sum += maxdice(i, 0);
				dicestack(i, 1, sum);
				sum -= maxdice(i, 0);
			}
		} else {
			int prevtopvalue = dice[size-1][prevtopidx];
			int nowtopidx = -1;
			
			for (int i = 0; i < 6; i++) {
				if (dice[size][i] == prevtopvalue) nowtopidx = except[i][1];
			}
			sum += maxdice (nowtopidx, size);
			dicestack (nowtopidx, size + 1, sum);
		}
	}
	
	static int maxdice (int topidx, int size) {
		int max = 0;
		
		for (int i = 0; i < 6; i++) {
			if (i == except[topidx][0] || i == except[topidx][1]) continue;
			if (max < dice[size][i]) max = dice[size][i];
		}
		
		return max;
	}
}