import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.valueOf(br.readLine());

		char[] temp = br.readLine().toCharArray();

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += temp[i] - '0';
		}

		System.out.println(sum);
	}
}
