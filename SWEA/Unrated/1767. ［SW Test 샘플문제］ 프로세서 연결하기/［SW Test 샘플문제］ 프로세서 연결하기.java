import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] map;
	static List<int[]> cores;
	static int cs;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int resCore;
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.valueOf(br.readLine());

		for (int t = 1; t <= tc; t++) {
			resCore = Integer.MIN_VALUE;
			res = Integer.MAX_VALUE;
			n = Integer.valueOf(br.readLine());
			map = new int[n][n];
			cores = new ArrayList<int[]>();

			for (int r = 0; r < n; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < n; c++) {
					map[r][c] = Integer.valueOf(st.nextToken());
					// 코어 위치 입력받기 (외곽 제외)
					if (map[r][c] == 1 && (r != 0 && r != n - 1 && c != 0 && c != n - 1))
						cores.add(new int[] { r, c });
				}
			}

			cs = cores.size();

			makeProsessor(0, 0);

			System.out.println("#" + t + " " + res);
		}
	}

	static void makeProsessor(int idx, int core) {
		if (idx == cs && resCore <= core) {
			int cnt = 0;

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (map[r][c] == 2)
						cnt++;
				}
			}

			if (resCore < core || (resCore == core && res > cnt)) {
				resCore = core;
				res = cnt;
			}
			return;
		}

		if (idx == cs)
			return;

		for (int i = 0; i < 4; i++) {
			if (islink(cores.get(idx)[0], cores.get(idx)[1], i)) {
				linkcore(cores.get(idx)[0], cores.get(idx)[1], i, 2);
				makeProsessor(idx + 1, core + 1);
				linkcore(cores.get(idx)[0], cores.get(idx)[1], i, 0);
			}
		}
		makeProsessor(idx + 1, core);
	}

	static void linkcore(int r, int c, int dir, int putPick) {
		while (true) {
			r += dr[dir];
			c += dc[dir];

			if (r < 0 || r >= n || c < 0 || c >= n)
				return;

			map[r][c] = putPick;
		}
	}
	
	static boolean islink(int r, int c, int dir) {
		while (true) {
			r += dr[dir];
			c += dc[dir];
			
			if (r < 0 || r >= n || c < 0 || c >= n)
				return true;
			
			if (map[r][c] != 0)
				return false;
		}
	}
}