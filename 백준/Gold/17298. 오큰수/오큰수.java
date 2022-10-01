import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] res = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> s = new Stack<>();
		
		for (int i = n - 1; i >= 0; i--) {
			while(!s.empty() && arr[i] >= s.peek()) {
				s.pop();
			}
			if(s.empty()) {
				res[i] = -1;
				s.push(arr[i]);
			} else {
				res[i] = s.peek();
				s.push(arr[i]);
			}
		}
		
		for (int i = 0; i < n; i++) {
			bw.append(res[i] + " ");
		}
		bw.flush();
	}
}