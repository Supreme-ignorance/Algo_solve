import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dfs(1, 1, n);
	}
	//루트 노드의 깊이를 1로 둔다.
	static void dfs(int col, int depth, int n) {
		if (depth == n) {
			System.out.print(col + " ");
			return;
		}
		
		int node = (int) (Math.pow(2, n) - Math.pow(2, depth - 1) - col + 1);
		
		System.out.print(node + " ");
		dfs(col, depth + 1, n);
		dfs(col + (int) Math.pow(2, depth-1), depth + 1, n);
	}
}