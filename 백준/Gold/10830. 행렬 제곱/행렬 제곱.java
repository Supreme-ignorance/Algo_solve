import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long b;
	static int[][] arr;
	static Map<Long, int[][]> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		b = Long.parseLong(st.nextToken());
		arr = new int[n][n];
		
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < n; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		map.put((long) 1, arr);
		
		arr = exponentiation(b);
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	static int[][] matrixMultiplication(int[][] A, int[][] B) {
		int row = A.length;
		int Acolum = A[0].length;
		int colum = B[0].length;
		
		int[][] temp = new int[row][colum];
		
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < colum; c++) {
				for (int a = 0; a < Acolum; a++) {
					temp[r][c] += (A[r][a] * B[a][c]);
				}
				temp[r][c] = temp[r][c] % 1000;
			}
		}
		
		return temp;
	}
	
	static int[][] exponentiation(long num) {
		if (map.containsKey(num)) {
			return map.get(num);
		}
		
		if (num % 2 == 1) {
			map.put(num, matrixMultiplication(exponentiation(num / 2), exponentiation(num / 2 + 1)));
		} else {
			map.put(num, matrixMultiplication(exponentiation(num / 2), exponentiation(num / 2)));
		}
		
		return map.get(num);
	}
}