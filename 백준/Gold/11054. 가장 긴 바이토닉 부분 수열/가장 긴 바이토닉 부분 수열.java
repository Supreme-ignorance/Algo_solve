import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] dpUp;
	static int[] dpDown;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		dpUp = new int[n];
		dpDown = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dpUp[0] = 1;
		dpDown[n - 1] = 1;
		int res = 1;
		
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					dpUp[i] = Math.max(dpUp[j] + 1, dpUp[i]);
				}
			}
			if (dpUp[i] == 0) dpUp[i] = 1;
		}
		
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] > arr[j]) {
					dpDown[i] = Math.max(dpDown[j] + 1, dpDown[i]);
				}
			}
			if (dpDown[i] == 0) dpDown[i] = 1;
		}
		
//		System.out.println(Arrays.toString(dpUp));
//		System.out.println(Arrays.toString(dpDown));
		
		for (int i = 0; i < n; i++) {
			res = Math.max(res, dpUp[i] + dpDown[i] - 1);
		}
		
		System.out.println(res);
	}
}