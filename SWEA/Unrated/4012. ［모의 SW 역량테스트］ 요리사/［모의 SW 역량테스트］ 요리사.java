import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int n;
	static boolean[] cell;
	static boolean[] synergy;
	static int [] temp = new int[2];
	
	static int tempRes;
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			res = Integer.MAX_VALUE;

			n = Integer.parseInt(br.readLine());

			arr = new int[n + 1][n + 1];
			cell = new boolean[n + 1];
			synergy = new boolean[n / 2];

			for (int r = 1; r < n + 1; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 1; c < n + 1; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			combination(1, 0, n / 2);

			System.out.println("#" + t + " " + res);
		}
	}

	static void combination (int s, int depth, int end) {
		if (depth == end) {
			int cellIdx = 0;
			int unCellIdx = 0;
			
			int[] cellected = new int[n / 2];
			int[] unCellected = new int[n / 2];
			
			for (int i = 1; i < n + 1; i++) {
				if (cell[i]) cellected[cellIdx++] = i;
				else unCellected[unCellIdx++] = i;
			}
			
			tempRes = 0;
			permutation(cellected, 0, 2, true);
			permutation(unCellected, 0, 2, false);
			tempRes = Math.abs(tempRes);
			
			if (tempRes < res) res = tempRes;
			return;
		}
		for (int i = s; i < n + 2 - end + depth; i++) {
			if (!cell[i]) {
				cell[i] = true;
				combination(i + 1, depth + 1, end);
				cell[i] = false;
			}
		}
	}
	
	static void permutation (int[] subarr, int depth, int end, boolean isPlus) {
		if (depth == end) {
			if (isPlus) tempRes += arr[temp[0]][temp[1]];
			else tempRes -= arr[temp[0]][temp[1]];
			return;
		}

		for (int i = 0; i < n / 2; i++) {
			if (!synergy[i]) {
				synergy[i] = true;
				temp[depth] = subarr[i];
				permutation(subarr, depth + 1, end, isPlus);
				synergy[i] = false;
			}
		}
	}
}