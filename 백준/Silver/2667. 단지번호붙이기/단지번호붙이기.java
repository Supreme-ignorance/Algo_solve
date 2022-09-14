import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int n;
	static boolean[][] checked;
	static List<Integer> size = new ArrayList<Integer>();
	static Queue<int[]> apt = new LinkedList<int[]>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		n = Integer.parseInt(br.readLine());

		checked = new boolean[n][n];
		
		for (int r = 0; r < n; r++) {
			String input = br.readLine();
			for (int c = 0; c < n; c++) {
				if (input.charAt(c) == '0') checked[r][c] = true;
			}
		}
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				findApartment(r, c);
			}
		}
		
		Collections.sort(size);
		
		int complex = size.size();
		
		System.out.println(complex);
		
		for (int i = 0; i < complex; i++) {
			System.out.println(size.get(i));
		}
	}
	
	static void findApartment(int r, int c) {
		if (!checked[r][c]) {
			
			checked[r][c] = true;
			int tempsize = 1;
			apt.add(new int[] { r, c });

			while (!apt.isEmpty()) {
				for (int i = 0; i < 4; i++) {
					int tempr = apt.peek()[0] + dr[i];
					int tempc = apt.peek()[1] + dc[i];

					if (tempr < 0 || tempr >= n || tempc < 0 || tempc >= n)
						continue;
					if (!checked[tempr][tempc]) {
						apt.add(new int[] { tempr, tempc });
						checked[tempr][tempc] = true;
						tempsize++;
					}
				}
				apt.poll();
			}

			size.add(tempsize);
		}
	}
}