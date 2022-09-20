import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] meter = new int[6][2];
		
		for (int i = 0; i < 6; i++) {
			meter[i][0] = sc.nextInt();
			meter[i][1] = sc.nextInt();
		}
		
		int except = 0;
		int width = 1;
		
		//find
		for (int i = 0; i < 6; i++) {
			int pre = (i - 1 < 0)? (6 + (i - 1)) : i - 1;
			int next = (i + 1) % 6;
			int nextnext = (i + 2) % 6;
			
			if (meter[i][0] == meter[nextnext][0] && meter[pre][0] == meter[next][0]) {
				except = meter[i][1] * meter[next][1];
				
				for (int j = 0; j < 6; j ++) {
					if (meter[j][0] != meter[i][0] && meter[j][0] != meter[next][0]) {
						width *= meter[j][1];
					}
				}
			}
		}
		
		int res = n * (width - except);		
		System.out.println(res);
	}
}