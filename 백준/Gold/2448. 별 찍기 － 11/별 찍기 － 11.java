import java.util.*;

public class Main {
	static char[][] map;
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int input = sc.nextInt();
		
		n = input;
		m = input / 3 * 6 - 1;
		
		map = new char[n][m];
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				map[r][c] = ' ';
			}
		}
		
		starDraw(input, n-1, 0, n, m);
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void starDraw (int input, int dr, int dc, int h, int w) {
		if (input == 3) {
			for (int r = dr; r >= dr - 2; r--) {
				for (int c = dc; c < dc + 5; c++) {
					if (r == dr) map[r][c] = '*';
					if (r == dr - 1 && (c - dc) % 2 == 1) map[r][c] = '*';
					if (r == dr - 2 && (c - dc) == 2) map[r][c] = '*';
				}
			}
			return;
		}
		
		starDraw (input / 2, dr, dc, h / 2, w / 2); // 왼
		starDraw (input / 2, dr, dc + w / 2 + 1, h / 2, w / 2); // 오
		starDraw (input / 2, dr - h / 2, dc + (w + 1) / 4, h / 2, w / 2); // 위
	}
}