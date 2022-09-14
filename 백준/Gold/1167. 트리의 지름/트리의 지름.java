import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static List<int[]>[] connect;
	static List<Integer> isleaf = new ArrayList<Integer>();
	static boolean[] visited;
	static int maxdist = 0;
	static int maxidx = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		connect = new List[n + 1];
		
		for (int i = 1; i < n + 1; i++) {
			connect[i] = new ArrayList<int[]>();
		}
		
		
		int max = 2;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			
			while (true) {
				int conneted = Integer.parseInt(st.nextToken());
				if (conneted == -1) break;
				int dist = Integer.parseInt(st.nextToken());
				
				int[] in = {conneted, dist};
				
				connect[node].add(in);
			}
			
			if (connect[node].size() == 1) isleaf.add(node);
		}
		
		int last = isleaf.get(isleaf.size() - 1);
		
		visited = new boolean[n + 1];
		dfs(last, 0);
		visited = new boolean[n + 1];
		dfs(maxidx, 0);
		
		System.out.println(maxdist);
	}
	
	static void dfs(int input, int dist) {
		
		visited[input] = true;
		
		for (int[] i : connect[input]) {
			if (!visited[i[0]]) {
				int temp = dist + i[1];
				if (maxdist < temp) {
					maxdist = temp;
					maxidx = i[0];
				}
				dfs(i[0], temp);
			}
		}
	}
}