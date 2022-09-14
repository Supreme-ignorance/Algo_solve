import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] home;
	static int[][] store;
	static boolean[] visited;
	static int[] goal;
	static int n;
	static boolean isCanGo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			// 초기화
			isCanGo = false;
			
			n = Integer.parseInt(br.readLine());
			
			store = new int[n][2];
			visited = new boolean[n];
			
			// 상대 좌표계로 구현
			st = new StringTokenizer(br.readLine());
			home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken()) - home[0];
				store[i][1] = Integer.parseInt(st.nextToken()) - home[1];
			}
			
			st = new StringTokenizer(br.readLine());
			goal = new int[] {Integer.parseInt(st.nextToken()) - home[0], Integer.parseInt(st.nextToken()) - home[1]};
			
			dfs(0, 0);
			
			if (isCanGo) System.out.println("happy");
			else System.out.println("sad");
		}
	}
	
	static void dfs(int x, int y) {
		// 도착 조건
		if (Math.abs(goal[0] - x) + Math.abs(goal[1] - y) <= 1000) {
			isCanGo = true;
		}

		// 생각 없이 false 쓰지 말것
		for (int i = 0; i < n; i++) {
			if (!visited[i] && Math.abs(store[i][0] - x) + Math.abs(store[i][1] - y) <= 1000) {
				visited[i] = true;
				dfs(store[i][0], store[i][1]);
			}
		}
	}
}