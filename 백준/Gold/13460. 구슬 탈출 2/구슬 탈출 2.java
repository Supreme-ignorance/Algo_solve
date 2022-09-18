import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int n;
	static int m;
	static int maxMove;
	
	static char[][] map;
	static Queue<int[]> Q = new LinkedList<>();
	static Queue<int[]> eve = new LinkedList<>();
	
	static int[] initialR = new int[2];
	static int[] initialB = new int[2];
	static boolean success = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maxMove = Math.max(n, m) - 2;
		
		map = new char[n][m];
		
		for (int r = 0; r < n; r++) {
			char[] temp = br.readLine().toCharArray();
			for (int c = 0; c < m; c++) {
				map[r][c] = temp[c];
				checkPosition(r, c);
			}
		}
		
		Q.add(new int[] {initialR[0], initialR[1], initialB[0], initialB[1], 0});
		eve.add(new int[] {initialR[0], initialR[1], initialB[0], initialB[1], 0});
		bfs(0);
	}
	
	static void bfs (int tryNum) {
		if (tryNum == 10) {
			System.out.println(-1);
			return;
		}
		
		tryNum++;
		int qsize = Q.size();
		
		for (int i = 0; i < qsize; i++) {
			
			for (int j = 0; j < 4; j++) {
				incline(j);
				if (success) {
					System.out.println(tryNum);
					return;
				}
			}
			
			eve.poll();
			eve.add(Q.poll());
		}
		
		bfs (tryNum);
	}
	
	static void incline (int dir) {
		int[] temp = Q.peek();
		int RMoveDist = 0;
		int BMoveDist = 0;
		
		int Rr;
		int Rc;
		int Br;
		int Bc;
		
		while (true) {
			Rr = temp[0] + ++RMoveDist * dr[dir];
			Rc = temp[1] + RMoveDist * dc[dir];
			
			if (map[Rr][Rc] == 'O') {
				success = true;
				break;
			} else if (map[Rr][Rc] == '#') {
				Rr -= dr[dir];
				Rc -= dc[dir];
				break;
			}
		}
		
		while (true) {
			Br = temp[2] + ++BMoveDist * dr[dir];
			Bc = temp[3] + BMoveDist * dc[dir];
			
			if (map[Br][Bc] == 'O') {
				success = false;
				return;
			} else if (map[Br][Bc] == '#') {
				Br -= dr[dir];
				Bc -= dc[dir];
				break;
			}
		}
		
		// 덜 이동한쪽이 더 빨리 도착함
		if (Rr == Br && Rc == Bc) {
			if (RMoveDist > BMoveDist) {
				Rr -= dr[dir];
				Rc -= dc[dir];
			} else {
				Br -= dr[dir];
				Bc -= dc[dir];
			}
		}
		
		if (Rr != temp[0] || Rc != temp[1] || Br != temp[2] || Bc != temp[3]) {
			int[] tempeve = eve.peek();
			if (Rr != tempeve[0] || Rc != tempeve[1] || Br != tempeve[2] || Bc != tempeve[3]) {
				Q.add(new int[] {Rr, Rc, Br, Bc, temp[4] + 1});
			}
		}
	}
	
	/**
	 * 각 구슬과 구멍의 위치를 파악
	 * @param r
	 * @param c
	 * 
	 */
	static void checkPosition (int r, int c) {
		if (map[r][c] == 'R') {
			initialR[0] = r;
			initialR[1] = c;
		} else if (map[r][c] == 'B') {
			initialB[0] = r;
			initialB[1] = c;
		}
	}
}