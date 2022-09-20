import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n][n];

		PriorityQueue<numWithC> pq = new PriorityQueue<>();
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				arr[r][c] = sc.nextInt();
				if (r == n-1) pq.add(new numWithC(arr[r][c], r, c));
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (i == n-1) {
				System.out.println(pq.poll().num);
				break;
			}
			if (pq.peek().r - 1 >= 0) {
				pq.add(new numWithC(arr[pq.peek().r - 1][pq.peek().c], pq.peek().r - 1, pq.peek().c));
			}
			pq.poll();
		}
	}
}

class numWithC implements Comparable<numWithC> {
	int num;
	int r;
	int c;
	
	public numWithC(int num, int r, int c) {
		super();
		this.num = num;
		this.r = r;
		this.c = c;
	}

	@Override
	public int compareTo(numWithC o) {
        return this.num <= o.num ? 1 : - 1;
	}
}
