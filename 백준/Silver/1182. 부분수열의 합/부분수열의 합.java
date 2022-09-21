import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static int n;
	static int s;
	static int res = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		s = sc.nextInt();
		
		arr = new int[n];
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		subsequence(0);
		
		if (s == 0) res--;
		System.out.println(res);
	}

	static void subsequence(int depth) {
		if (depth == n) {
			int temp = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i]) temp += arr[i];
			}
			if (temp == s) {
				res++;
			}
			return;
		}

		if (!visited[depth]) {
			visited[depth] = true;
			subsequence(depth + 1);
			visited[depth] = false;
			subsequence(depth + 1);
		}
	}
}