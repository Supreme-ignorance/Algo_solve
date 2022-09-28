import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n; // 도시 갯수
	static int m; // 
	static int[][] map; // 
	static int[] route; // 
	static int[] p; // 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		map = new int[n + 1][n + 1];
		p = new int[n + 1];
		route = new int[m];
		
		for (int r = 1; r <= n; r++) {
			st = new StringTokenizer(br.readLine());			
			for (int c = 1; c <= n; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}	
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		
		makeSet();
		
		for (int r = 1; r <= n; r++) {		
			for (int c = r; c <= n; c++) {
				if (map[r][c] == 1) union(r, c);
			}	
		}
		
		int temp = findSet(route[0]);
		
		
		for (int i = 0; i < m; i++) {
			if (temp != findSet(route[i])) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
	
	private static void union(int r, int c) {
		p[findSet(c)] = findSet(r);
	}

	private static int findSet(int x) {
		if (p[x] != x) {
			x = findSet(p[x]);
		}

		return x;
	}

	private static void makeSet() {
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
	}
}