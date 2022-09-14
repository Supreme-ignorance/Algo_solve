import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] sl = new int [n+1];
		
		for(int i = 1; i <= n; i++) {
			sl[i] = sc.nextInt();
		}
		
		int p = sc.nextInt();
		
		for (int i = 0; i < p; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			
			switch (gender) {
				case 1 : 
					for (int j = 1; j <= n; j++) {
						if (j % num == 0) {
							if (sl[j] == 0) sl[j] = 1;
							else sl[j] = 0;
						}
					}
					break;
				case 2 : 
					for (int j = 0; ; j++) {
						if (num - j <= 0 || num + j > n) break;
						if (j == 0) {
							if (sl[num] == 0) sl[num] = 1;
							else sl[num] = 0;
						} else if (sl[num - j] == sl[num + j]) {
							if (sl[num - j] == 0) {
								sl[num - j] = 1;
								sl[num + j] = 1;
							}
							else {
								sl[num - j] = 0;
								sl[num + j] = 0;
							}
						} else {
							break;
						}
					}
					break;
			}//switch문
		}// 학생 값 입력받고 스위치 변경
		
		for(int i = 1; i <= n; i++) {
			if (i < n) System.out.print(sl[i] + " ");
            else if (i == n) System.out.print(sl[i]);
			if(i % 20 == 0) {
				System.out.println();
			}
		}
	}
}