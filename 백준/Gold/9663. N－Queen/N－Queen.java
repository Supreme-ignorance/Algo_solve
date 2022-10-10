import java.util.Scanner;

public class Main {

	static int n;
	static boolean[][] map;
	static int[] dc = {-1, 0, 1};
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			n = sc.nextInt();
			res = 0;

			map = new boolean[n][n];
			putQueen(0);
			
			System.out.println(res);
	}
	
	static void putQueen(int r) {
		if (r == n) {
			res++;
			return;
		}
		
		for (int c = 0; c < n; c++) {
			if (isPutable(r, c)) {
				map[r][c] = true;
				putQueen(r + 1);
				map[r][c] = false;
			}
		}
	}
	
	static boolean isPutable(int r, int c) {
		
		for(int i = 0; i < 3; i++) {
			for (int j = 1; j < n; j++) {
				int insr = r + j * -1;
				int insc = c + j * dc[i];
				
				if (insr < 0 || insc < 0 || insc >= n) break;
				
				if (map[insr][insc]) return false;
			}
		}
		
		return true;
	}
}