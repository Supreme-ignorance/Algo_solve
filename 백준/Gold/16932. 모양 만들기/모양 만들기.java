import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dp;
	static Queue<int[]> Q = new LinkedList<>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];
		dp = new int[n * m / 2 + n * m % 2 + 1];

		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				map[r][c] = Integer.valueOf(st.nextToken());
				if (map[r][c] == 0)
					visited[r][c] = true;
			}
		}

		numbering(0, 0, 1);
		
		int res = 2;
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (map[r][c] == 0) {
					HashSet<Integer> chk = new HashSet<Integer>();
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						if (nr < 0 || nr >= n || nc < 0 || nc >= m)
							continue;
						
						chk.add(map[nr][nc]);
					}
					
					int sum = 1;
					
					for (int i : chk) {
						sum += dp[i];
					}
					
					res = Math.max(res, sum);
				}
			}
		}
		
		System.out.println(res);
	}

	private static void numbering(int r, int c, int num) {
		while (visited[r][c]) {
			if (++r == n) {
				if (++c == m) {
					return;
				}
				r = 0;
			}
		}

		Q.add(new int[] { r, c });
		int cnt = 0;

		while (!Q.isEmpty()) {
			int[] temp = Q.poll();
			map[temp[0]][temp[1]] = num;
			visited[temp[0]][temp[1]] = true;
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					Q.add(new int[] { nr, nc });
				}
			}
		}
		
		dp[num] = cnt;
		numbering(r, c, num + 1);
	}
}