import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n;
	static int res = 0;
	static final int HORI = -1;
	static final int VERTI = -2;
	static final int DIAG = -3;
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for (int r = 0; r < n; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < n; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0, 1);
		
		System.out.println(res);
	}
	
	static void dfs(int Lr, int Lc, int Rr, int Rc) {
		if (Rr == n - 1 && Rc == n - 1) {
			res++;
			return;
		}
		
		int state = 0;
		
		if (Rr - Lr == 1 && Rc - Lc == 1) state = DIAG; 
		else if (Rr - Lr == 1) state = VERTI;
		else if (Rc - Lc == 1) state = HORI;
		
		for (int i = 0; i < 3; i++) {
			if (state == HORI && i == 1) continue; 
			if (state == VERTI && i == 0) continue;
			
			int nr = Rr + dr[i];
			int nc = Rc + dc[i];
			
			// 범위 바깥인가?
			if (nr >= n || nc >= n || map[nr][nc] == 1) continue;
			// 기둥이 문제인가?
			if (i == 2 && (map[nr][Rc] == 1 || map[Rr][nc] == 1)) continue;
			
			dfs(Rr, Rc, nr, nc);
		}
	}
}
