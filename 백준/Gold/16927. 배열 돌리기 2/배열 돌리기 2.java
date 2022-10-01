import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		ArrayTurn(arr, r);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	static void ArrayTurn(int[][] arr, int r) {
		
		int time = Math.min(arr.length, arr[0].length) / 2;
		List<Integer> line = new ArrayList<Integer>();
		
		for (int i = 0; i < time; i++) {
			// 좌측
			for (int a = i; a < arr.length - 1 - i; a++) {
				line.add(arr[a][i]);
			}
			// 하측
			for (int a = i; a < arr[0].length - 1 - i; a++) {
				line.add(arr[arr.length - 1 - i][a]);
			}
			// 우측
			for (int a = arr.length - 1 - i; a >= 1 + i; a--) {
				line.add(arr[a][arr[0].length - 1 - i]);
			}
			// 상측
			for (int a = arr[0].length - 1 - i; a >= 1 + i; a--) {
				line.add(arr[i][a]);
			}
			
			// r칸 이동
			int[] temp = new int[line.size()];
			for (int b = 0; b < line.size(); b++) {
				temp[(r + b) % line.size()] = line.get(b);
			}
			
			line.clear();
			
			int j = 0;
			// 좌측 입력
			for (int a = i; a < arr.length - 1 - i; a++) {
				arr[a][i] = temp[j++];
			}
			// 하측 입력
			for (int a = i; a < arr[0].length - 1 - i; a++) {
				arr[arr.length - 1 - i][a] = temp[j++];
			}
			// 우측 입력
			for (int a = arr.length - 1 - i; a >= 1 + i; a--) {
				arr[a][arr[0].length - 1 - i] = temp[j++];
			}
			// 상측 입력
			for (int a = arr[0].length - 1 - i; a >= 1 + i; a--) {
				arr[i][a] = temp[j++];
			}
		}
	}
}