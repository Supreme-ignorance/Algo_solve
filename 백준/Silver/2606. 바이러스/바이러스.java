import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static List<Integer>[] input;
	static boolean[] visited;
	static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		input = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			input[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			input[first].add(second);
			input[second].add(first);
		}
		
		dfs(1);
		
		System.out.println(cnt);
	}
	
	static void dfs (int idx) {
		visited[idx] = true;
		for (int i : input[idx]) {
			if (!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
	}
}