import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long K = sc.nextLong();
		long left = 1;
		long right = N * N;
		long ans = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			long cnt = search(mid, N);
			if (cnt >= K) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}

	static long search(long mid, long N) {
		long cnt = 0;
		for (long i = 1; i <= N; i++) {
			cnt += Math.min(mid / i, N);
		}

		return cnt;
	}
}