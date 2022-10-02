import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n; // number of GOAT
	static int m; // number of connect
	static SpaceGOAT[] GOATList;
	static boolean[][] connected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		GOATList = new SpaceGOAT[n + 1];
		connected = new boolean[n + 1][n + 1];
		
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			GOATList[i] = new SpaceGOAT(x, y);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			connected[x][y] = true;
			connected[y][x] = true;
		}
		
		// prim algo
		
		double[] dist = new double[n + 1];
		boolean[] visited = new boolean[n + 1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		for (int i = 0; i < n -1; i++) {
			int idx = -1;
			double min = Double.MAX_VALUE;
			for (int j = 1; j < n + 1; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			visited[idx] = true;
			
			for (int j = 1; j < n + 1; j++) {
				if (!visited[j]) {
					if (!connected[idx][j]) {
						int x = GOATList[idx].x - GOATList[j].x;
						int y = GOATList[idx].y - GOATList[j].y;
						double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
						if (dist[j] > distance)
							dist[j] = distance;
					} else {
						dist[j] = 0;
					}
				}
			}
		}
		
		double sum = 0;
		for (int i = 1; i < n + 1; i++) {
			sum += dist[i];
		}
		
		System.out.println(String.format("%.2f", sum));
	}
}

class SpaceGOAT{
	int x;
	int y;
	
	public SpaceGOAT(int x, int y) {
		this.x = x;
		this.y = y;
	}
}