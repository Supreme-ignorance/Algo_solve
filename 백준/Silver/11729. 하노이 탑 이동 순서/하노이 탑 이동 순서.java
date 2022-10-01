import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		bw.write((int)Math.pow(2, n)-1 + "\n");
		
		//하노이의 탑
		tower_of_hanoi(n, 1, 3, 2);

		bw.flush();
		bw.close();
	}

	static void tower_of_hanoi(int n, int from, int to, int temp) throws IOException {
		/**n크기의 탑을 옮기기위해선 
		 *n-1크기의 탑을 목표와 다른 기둥으로 옮기고 
		 *n번째 원판을 목표기둥으로 옮기고
		 *n-1크기의 탑을 목표 기둥으로 옮기면 된다.
		 *이상을 코드로 나타내면 아래와 같다.
		 */
		if (n == 1) swap(from, to);
		else {
			tower_of_hanoi(n-1, from, temp, to); // n-1크기의 탑을 목표와 다른 기둥으로 옮긴다.
			swap(from, to); // n번째 원판을 목표기둥으로 옮긴다.
			tower_of_hanoi(n-1, temp, to, from); // n-1크기의 탑을 목표 기둥으로 옮긴다.
		}
	}
	// 기둥 간 교환 출력
	static void swap(int a, int b) throws IOException {
		bw.write(a + " " + b + "\n");
	}
}