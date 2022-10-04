import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Long> fac;
	static int decimal = 1000000007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.valueOf(br.readLine());

		fac = new ArrayList<Long>();
		fac.add((long) 1);
		fac.add((long) 1);
		
		for (int i = 2; i < 4000001; i++) {
			fac.add(((i % decimal) * fac.get(i - 1)) % decimal);
		}

		for (int tc = 0; tc < m; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(st.nextToken());
			int k = Integer.valueOf(st.nextToken());

			long numerator = fac.get(n);
			long denominator = (fac.get(n - k) * fac.get(k)) % decimal;

			long res = (numerator * (pow(denominator, decimal - 2) % decimal)) % decimal;

			System.out.println(res);
		}
	}

	public static long pow(long a, long b) {
		if (b == 0)
			return 1;
		long ans = pow(a, b / 2);
		long next = (ans * ans) % 1000000007;
		if (b % 2 == 0)
			return next;
		else
			return (next * a) % 1000000007;
	}

}
