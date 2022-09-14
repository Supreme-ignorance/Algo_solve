import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int F;
	static int S;
	static int G;
	static int U;
	static int D;
	static Queue<int[]> q = new LinkedList<int[]>();
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F + 1];
		
		visited[S] = true;
		q.add(new int[] {S, 0});
		
		bfs();
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			int currentFloor = q.peek()[0];
			int cnt = q.poll()[1];
			
			if (currentFloor == G) {
				System.out.println(cnt);
				return;
			}
			
			int upFloor = currentFloor + U;
			int downFloor = currentFloor - D;
			cnt++;
			
			if (upFloor <= F && !visited[upFloor]) {
				visited[upFloor] = true;
				q.add(new int[] {upFloor, cnt});
			}
			
			if (downFloor > 0 && !visited[downFloor]) {
				visited[downFloor] = true;
				q.add(new int[] {downFloor, cnt});
			}
		}
		System.out.println("use the stairs");
	}
}