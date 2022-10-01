import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int k;
	static int[][] arr;
	static int[][] input;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n][m];
		
		k = sc.nextInt();
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		input = new int[k][3];
		boolean[] check = new boolean[k];
 		
		for (int i = 0; i < k; i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
			input[i][2] = sc.nextInt();
		}
		
		process (0, k, check);
		
		System.out.println(min);
	}
	
	static void process (int state, int deapth, boolean[] check) {
		if (state == deapth) {
			for (int r = 0; r < n; r++) {
				int sum = 0;
				for (int c = 0; c < m; c++) {
					sum += arr[r][c];
				}
				if (min > sum) min = sum;
			}
			return;
		}
		
		for (int i = 0; i < k; i++) {
			if (!check[i]) {
				check[i] = true;
				int[][] prevarr = new int[n][m];
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < m; c++) {
						prevarr[r][c] = arr[r][c];
					}
				}
				ArrayTurn(input[i][0] - 1, input[i][1] - 1, input[i][2]);
				process (state + 1, deapth, check);
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < m; c++) {
						arr[r][c] = prevarr[r][c];
					}
				}
				check[i] = false;
			}
		}
	}
	
	static void ArrayTurn(int sr, int sc, int range) {
		int[][] temp = new int[n][m];
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				temp[r][c] = arr[r][c];
			}
		}
		
		for (int i = 0; i < range; i++) {
			for (int c = sc - range + i; c < sc + range - i; c++) {
				temp[sr - range + i][c+1] = arr[sr - range + i][c];
			}
			for (int r = sr - range + i; r < sr + range - i; r++) {
				temp[r+1][sc + range - i] = arr[r][sc + range - i];
			}
			for (int c = sc - range + 1 + i; c <= sc + range - i; c++) {
				temp[sr + range - i][c-1] = arr[sr + range - i][c];
			}
			for (int r = sr - range + 1 + i; r <= sr + range - i; r++) {
				temp[r-1][sc - range + i] = arr[r][sc - range + i];
			}
		}
		
		for (int r = sr - range; r <= sr + range; r++) {
			for (int c = sc - range; c <= sc + range; c++) {
				arr[r][c] = temp[r][c];
			}
		}
	}
}