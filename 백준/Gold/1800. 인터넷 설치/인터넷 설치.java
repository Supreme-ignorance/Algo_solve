import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int p;
	static int k;
	static int[][] map;
	static int[][] weight;
	static PriorityQueue<Node> pq;
	static int res = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		p = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		
		map = new int[n + 1][n + 1];
		
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			int price = Integer.valueOf(st.nextToken());
			map[r][c] = map[c][r] = price;
		}
		
		binarySearch(0, 1000000);
		
		System.out.println(res);
	}
	
	private static void binarySearch(int st, int ed) {
		if (st == ed) {
			res = st;
			return;
		}
		int mid = (st + ed) / 2;
		
		Weight(mid);
		
		int chk = dijkstra();
		
		if (chk == -1)
			return;
		else if (chk > k) 
			binarySearch(mid + 1, ed);
		else 
			binarySearch(st, mid);
	}

	private static int dijkstra() {
		pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[n + 1][n + 1];
		
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			int now = node.now;
			int stack = node.stack;
			
			if (now == n) {
				return stack;
			}
			
			for (int i = 2; i < n + 1; i++) {
				if (!visited[now][i] && map[now][i] > 0) {
					visited[now][i] = true;
					pq.add(new Node(i, stack + weight[now][i]));
				}
			}
		}
		
		return -1;
	}

	private static void Weight(int mid) {
		weight = new int[n + 1][n + 1];
		for (int r = 0; r < n + 1; r++) {
			for (int c = 0; c < n + 1; c++) {
				if (mid < map[r][c])
					weight[r][c] = 1;
			}
		}
	}
}

class Node implements Comparable<Node>{
	int now;
	int stack;
	
	public Node(int now, int stack) {
		this.now = now;
		this.stack = stack;
	}

	@Override
	public int compareTo(Node o) {
		return this.stack - o.stack;
	}
}