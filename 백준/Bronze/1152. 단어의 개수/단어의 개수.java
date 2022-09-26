import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		
		int cnt = 0;
		while (st.hasMoreTokens()) {
			st.nextToken();
			cnt++;
		}
		
		System.out.println(cnt);
	}
}