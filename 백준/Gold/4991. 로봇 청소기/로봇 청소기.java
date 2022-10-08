import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w;
	static int h;
	static boolean[][] ispass;
	static boolean[][] visited;
	static int[][] adj;
	static int[][] dp;
	static gar[] garlist;
	static int garnum;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());

			w = Integer.valueOf(st.nextToken());
			h = Integer.valueOf(st.nextToken());

			if (w == 0) {
				System.out.println(sb);
				return;
			}

			ispass = new boolean[h][w];
			visited = new boolean[h][w];
			garlist = new gar[11];
			garnum = 1;

			for (int r = 0; r < h; r++) {
				String temp = br.readLine();
				for (int c = 0; c < w; c++) {
					char point = temp.charAt(c);

					if (point == 'o') {
						garlist[0] = new gar(r, c);
					} else if (point == '*')
						garlist[garnum++] = new gar(r, c);

					if (point != 'x') {
						ispass[r][c] = true;
					}
				}
			}

			adj = new int[garnum][garnum];

			if (makeadj()) {
				dp = new int[garnum][(1 << garnum) - 1];
				
				for (int i = 0; i < garnum; i++) {
					Arrays.fill(dp[i], Integer.MAX_VALUE);
				}

				sb.append(dfs(0, 1) + "\n");
			} else
				sb.append("-1\n");
		}
	}

	public static int dfs(int now, int visit) {

		if (visit == (1 << garnum) - 1) {
			return 0;
		}

		if (dp[now][visit] != Integer.MAX_VALUE) {
			return dp[now][visit];
		}

		for (int i = 0; i < garnum; i++) {
			if ((visit & (1 << i)) == 0 && adj[now][i] != 0) {
				dp[now][visit] = Math.min(dp[now][visit], dfs(i, visit | (1 << i)) + adj[now][i]);
			}
		}

		return dp[now][visit];
	}

	private static boolean makeadj() {
		for (int i = 0; i < garnum; i++) {
			for (int j = i + 1; j < garnum; j++) {
				gar st = garlist[i];
				gar end = garlist[j];

				Queue<int[]> Q = new LinkedList<int[]>();
				Q.add(new int[] { st.r, st.c, 0 });

				adj[i][j] = adj[j][i] = Integer.MAX_VALUE;

				visited = new boolean[h][w];
				visited[st.r][st.c] = true;

				while (!Q.isEmpty()) {
					int r = Q.peek()[0];
					int c = Q.peek()[1];
					int dist = Q.poll()[2];

					if (r == end.r && c == end.c) {
						adj[i][j] = adj[j][i] = dist;
						break;
					}

					for (int k = 0; k < 4; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];

						if (nr < 0 || nr >= h || nc < 0 || nc >= w || !ispass[nr][nc])
							continue;

						if (!visited[nr][nc]) {
							visited[nr][nc] = true;
							Q.add(new int[] { nr, nc, dist + 1 });
						}
					}
				}

				if (adj[i][j] == Integer.MAX_VALUE)
					return false;
			}
		}
		return true;
	}
}

class gar {
	int r;
	int c;

	public gar(int r, int c) {
		this.r = r;
		this.c = c;
	}
}