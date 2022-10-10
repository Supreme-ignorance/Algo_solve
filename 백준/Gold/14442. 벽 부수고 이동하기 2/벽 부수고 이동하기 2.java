import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int k;
	static int[][] map;
	static boolean[][][] visited;
	static Queue<Node> Q = new LinkedList<>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m][k + 1];

		for (int r = 0; r < n; r++) {
			String temp = br.readLine();
			for (int c = 0; c < m; c++) {
				map[r][c] = temp.charAt(c) - '0';
			}
		}

		Q.add(new Node(0, 0, 1, 0));
		res = bfs();

		System.out.println(res);
	}

	private static int bfs() {
		while (!Q.isEmpty()) {
			Node node = Q.poll();
			
			int r = node.r;
			int c = node.c;
			int cnt = node.cnt;
			int alreadyBreak = node.alreadyBreak;
			
			if (r == n - 1 && c == m - 1) {
				return cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				
				if (alreadyBreak == k) {
					if (!visited[nr][nc][alreadyBreak] && map[nr][nc] == 0) {
						visited[nr][nc][alreadyBreak] = true;
						Q.add(new Node(nr, nc, cnt + 1, alreadyBreak));
					}
				} else if (alreadyBreak < k) {
					if (!visited[nr][nc][alreadyBreak] && map[nr][nc] == 0) {
						visited[nr][nc][alreadyBreak] = true;
						Q.add(new Node(nr, nc, cnt + 1, alreadyBreak));
					} else if (!visited[nr][nc][alreadyBreak + 1] && alreadyBreak != k) {
						visited[nr][nc][alreadyBreak + 1] = true;
						Q.add(new Node(nr, nc, cnt + 1, alreadyBreak + 1));
					}
				}
			}
		}
		
		return -1;
	}

	static class Node {
		int r;
		int c;
		int cnt;
		int alreadyBreak;

		public Node(int r, int c, int cnt, int alreadyBreak) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.alreadyBreak = alreadyBreak;
		}
	}
}