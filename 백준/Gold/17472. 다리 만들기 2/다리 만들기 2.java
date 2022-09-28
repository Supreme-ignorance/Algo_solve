import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int adjSize;
	static int[][] adj;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 0)
					visited[r][c] = true;
			}
		}
		
		// bfs를 이용한 확인 각 섬에 번호를 붙여준다.
		adjSize = islandNumbering() + 1;

		adj = new int[adjSize][adjSize];

		makeBridge();
		// 인접 행렬까지 이상 무
		
		int res = prim();

		// 배열 확인용
//		for (int r = 0; r < N; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		}
//		System.out.println();
//		for (int r = 0; r < adjSize; r++) {
//			System.out.println(Arrays.toString(adj[r]));
//		}
		
		System.out.println(res);
	}

	private static int prim() {
		
		int idx = 1;
		
		int[] dist = new int[adjSize];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[idx] = 0;
		dist[0] = 0;
		
		boolean[] cell = new boolean[adjSize];
		
		for (int i = 1; i < adjSize - 1; i++) {
			
			int min = Integer.MAX_VALUE;
			for (int j = 1; j < adjSize; j++) {
				if (!cell[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			cell[idx] = true;
			
			for (int j = 1; j < adjSize; j++) {
				if (!cell[j] && adj[idx][j] != 0 && dist[j] > adj[idx][j]) {
					dist[j] = adj[idx][j];
				}
			}
		}
		
		int res = 0;
		
		for (int i = 0; i < adjSize; i++) {
			if (dist[i] != Integer.MAX_VALUE)
				res += dist[i];
			else
				return -1;
		}
		
		if (res == 0) res = -1;
		
		return res;
	}

	private static void makeBridge() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				// 섬이라면
				if (map[r][c] != 0) {
					for (int i = 0; i < 4; i++) {
						int dis = 0;
						while (true) {
							dis++;
							int nr = r + dis * dr[i];
							int nc = c + dis * dc[i];

							if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
								break;
							}
							else if (map[nr][nc] == map[r][c]) {
								break;
							}
							else if (map[nr][nc] == 0) {
								continue;
							}
							else {
								dis--;
								if ((adj[map[r][c]][map[nr][nc]] > dis || adj[map[r][c]][map[nr][nc]] == 0) && dis > 1) {
									adj[map[r][c]][map[nr][nc]] = dis;
									adj[map[nr][nc]][map[r][c]] = dis;
								}
								break;
							}
						}
					}
				}
			}
		}
	}

	private static int islandNumbering() {
		Queue<int[]> Q = new LinkedList<>();

		int num = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!visited[r][c]) {
					num++;

					map[r][c] = num;
					visited[r][c] = true;

					Q.add(new int[] { r, c });

					while (!Q.isEmpty()) {
						int currentR = Q.peek()[0];
						int currentC = Q.poll()[1];

						for (int i = 0; i < 4; i++) {
							int nr = currentR + dr[i];
							int nc = currentC + dc[i];

							if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
								continue;

							visited[nr][nc] = true;
							map[nr][nc] = num;

							Q.add(new int[] { nr, nc });
						}
					}
				}
			}
		}

		return num;
	}
}