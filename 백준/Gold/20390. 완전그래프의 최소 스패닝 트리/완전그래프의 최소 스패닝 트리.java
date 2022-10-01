import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static long A, B, C, D;
	static final long INF = Long.MAX_VALUE;
	static long[] vertex;
	static boolean[] visited;
	static long[] dist;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		vertex = new long[n];
		visited = new boolean[n];
		dist = new long[n];
		
		Arrays.fill(dist, INF);
		
		st = new StringTokenizer(br.readLine());
		
		A = Long.valueOf(st.nextToken());
		B = Long.valueOf(st.nextToken());
		C = Long.valueOf(st.nextToken());
		D = Long.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			vertex[i] = Long.valueOf(st.nextToken());
		}
		
		long res = prim();
		
		System.out.println(res);
	}
	
	private static long prim() {
		
		int idx = -1;
		dist[0] = 0;
		
		for (int i = 0; i < n - 1; i++) {
			long min = INF;
			
			for (int j = 0; j < n; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			visited[idx] = true;
			
			for (int j = 0; j < n; j++) {
				if (!visited[j]) {
					
					long temp = 0;
					
					long idxquot;
					long idxrema;
					long jquot;
					long jrema;
					
					long idxres;
					long jres;
					
					if (idx < j) {
						idxquot = (A * (vertex[idx] / 1000000)) % C;
						idxrema = (A * (vertex[idx] % 1000000)) % C;
						jquot = (B * (vertex[j] / 1000000)) % C;
						jrema = (B * (vertex[j] % 1000000)) % C;
						
						idxres = (idxquot * 1000000 + idxrema) % C;
						jres = (jquot * 1000000 + jrema) % C;
						
						temp = (idxres % C + jres % C) % C;
					}
					else if (idx > j) {
						idxquot = (B * (vertex[idx] / 1000000)) % C;
						idxrema = (B * (vertex[idx] % 1000000)) % C;
						jquot = (A * (vertex[j] / 1000000)) % C;
						jrema = (A * (vertex[j] % 1000000)) % C;
						
						idxres = (idxquot * 1000000 + idxrema) % C;
						jres = (jquot * 1000000 + jrema) % C;
						
						temp = (idxres % C + jres % C) % C;
					}
					
					temp ^= D;
					
					dist[j] = Math.min(dist[j], temp);
				}
			}
		}
		
		long res = 0;
		
		for (int i = 0; i < n; i++) {
			res += dist[i];
		}
		
		return res;
	}
}