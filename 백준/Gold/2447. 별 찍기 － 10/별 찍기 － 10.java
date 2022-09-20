import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import jdk.nashorn.internal.ir.ContinueNode;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		String[][] list = new String[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				list[r][c] = " ";
			}
		}
		
		draw(list, n, 0, 0);
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				bw.write(list[r][c]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	static void draw(String[][] list, int n, int dr, int dc) {

		if (n == 3) {
			for (int r = dr; r < dr+n; r++) {
				for (int c = dc; c < dc+n; c++) {
					if (r-dr == 1 && c-dc == 1) continue; 
					else list[r][c] = "*";
				}
			}
		} else {
			for (int r = dr; r < dr+n; r += n / 3) {
				for (int c = dc; c < dc+n; c += n / 3) {
					if (r-dr == n / 3 && c-dc == n / 3) continue; 
					draw(list, n / 3, r, c);
				}
			}
		}
	}
}