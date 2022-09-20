import java.util.Scanner;

public class Main {
	static int cnt = 0;
	static int wantr;
	static int wantc;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		wantr = sc.nextInt();
		wantc = sc.nextInt();

		DaC(0, 0, n);
	}
	
	static void DaC(int r, int c, int n) {
		int scale = (int) Math.pow(2, n);
		int cd = (int) Math.pow(2, n - 1);
		// 최소 단위
		if (n == 1) {
			for (int i = r; i < r + scale; i += cd) {
				for (int j = c; j < c + scale; j += cd) {
					if (i == wantr && j == wantc) {
						System.out.println(cnt);
						return;
					}
					cnt++;
				}
			}
		} else {
			// 분할
			for (int i = r; i < r + scale; i += cd) {
				for (int j = c; j < c + scale; j += cd) {
					if (wantr >= i && wantc >= j && wantr < i + cd && wantc < j + cd) DaC(i, j, n - 1);
					else if (wantr >= i || wantc >= j) {
						cnt += (cd * cd);
					}
				}
			}
		}
	}
}
