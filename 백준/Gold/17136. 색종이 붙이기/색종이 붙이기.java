import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int size = 10;
	static boolean[][] visited = new boolean[size][size];
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 0;
		for (int r = 0; r < size; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < size; c++) {
				if (Integer.valueOf(st.nextToken()) == 0)
					visited[r][c] = true;
				else
					cnt++;
			}
		}

		find(0, 0, new int[] { cnt, 0, 0, 0, 0, 0 }, 0);

		if (res != Integer.MAX_VALUE)
			System.out.println(res);
		else
			System.out.println(-1);
	}

	static void find(int r, int c, int[] num, int cnt) {
		if (res <= cnt)
			return;
		if (num[0] == 0) {
			res = Math.min(res, cnt);
			return;
		}

		while (visited[r][c]) {
			if (++c >= size) {
				r++;
				if (r >= size)
					return;
				c = 0;
			}
		}
		
		for (int n = 5; n > 0; n--) {
			if (r + n > size || c + n > size || num[n] == 5)
				continue;
			
			if (isHaveSpace(r, c, n)) {
				fillNum(r, c, n);
				num[0] -= n * n;
				num[n]++;
				find(r, c, num, cnt + 1);
				num[n]--;
				num[0] += n * n;
				fillNum(r, c, n);
			}
		}
	}

	private static void fillNum(int r, int c, int n) {
		for (int sr = r; sr < r + n; sr++) {
			for (int sc = c; sc < c + n; sc++) {
				if (!visited[sr][sc]) {
					visited[sr][sc] = true;
				} else {
					visited[sr][sc] = false;
				}
			}
		}
	}

	static boolean isHaveSpace(int r, int c, int n) {
		for (int sr = r; sr < r + n; sr++) {
			for (int sc = c; sc < c + n; sc++) {
				if (visited[sr][sc])
					return false;
			}
		}

		return true;
	}
}