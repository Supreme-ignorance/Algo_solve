import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static Codi[][] parent;
	static int[][] L = new int[2][2];
	static boolean[][] visited;
	static Queue<Codi> Q = new LinkedList<>();
	static Queue<Codi> nQ = new LinkedList<>();
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());

		parent = new Codi[R][C];
		visited = new boolean[R][C];

		int Lidx = 0;

		for (int r = 0; r < R; r++) {
			String temp = br.readLine();
			for (int c = 0; c < C; c++) {
				char now = temp.charAt(c);
				parent[r][c] = new Codi(r, c);

				if (now == 'L') {
					L[Lidx][0] = r;
					L[Lidx++][1] = c;
				}

				if (now != 'X') {
					visited[r][c] = true;
				}
			}
		}

		initial();

		int res = check(1);
		System.out.println(res);
	}

	private static void initial() {

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (visited[r][c]) {
					Codi codi = new Codi(r, c);
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];

						if (nr < 0 || nr >= R || nc < 0 || nc >= C)
							continue;

						Codi ncodi = new Codi(nr, nc);

						if (!visited[nr][nc]) {
							nQ.add(codi);
						} else if (visited[nr][nc] && !isUnion(codi, ncodi)) {
							merge(codi, ncodi);
						}
					}
				}
			}
		}
		
		melt();
	}

	private static int check(int day) {
		Q = nQ;
		nQ = new LinkedList<>();

		while (!Q.isEmpty()) {
			Codi codi = Q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = codi.r + dr[i];
				int nc = codi.c + dc[i];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;

				Codi ncodi = new Codi(nr, nc);

				if (!visited[nr][nc]) {
					nQ.add(codi);
				} else if (visited[nr][nc] && !isUnion(codi, ncodi)) {
					merge(codi, ncodi);
					Q.add(ncodi);
				}
			}
		}

		if (!isUnion(parent[L[0][0]][L[0][1]], parent[L[1][0]][L[1][1]])) {
			melt();
			return check(day + 1);
		} else
			return day;
	}

	private static void melt() {
		int size = nQ.size();

		for (int i = 0; i < size; i++) {
			Codi codi = nQ.poll();
			nQ.add(codi);

			for (int j = 0; j < 4; j++) {
				int nr = codi.r + dr[j];
				int nc = codi.c + dc[j];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;

				visited[nr][nc] = true;
			}
		}
	}

	private static void merge(Codi codi1, Codi codi2) {
		Codi o1 = find(codi1);
		Codi o2 = find(codi2);

		if (o1 == o2)
			return;

		parent[o2.r][o2.c] = o1;
	}

	private static Codi find(Codi codi) {
		if (parent[codi.r][codi.c] == codi)
			return codi;
		return parent[codi.r][codi.c] = find(parent[codi.r][codi.c]);
	}

	private static boolean isUnion(Codi codi1, Codi codi2) {
		Codi o1 = find(codi1);
		Codi o2 = find(codi2);

		if (o1 == o2)
			return true;

		return false;
	}

	static class Codi {
		int r;
		int c;

		public Codi(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}