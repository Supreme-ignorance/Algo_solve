import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		int kill = -1;
		
		System.out.print("<");
		
		kill += k;
		kill = kill % list.size();
		System.out.print(list.remove(kill--));
		
		while (!list.isEmpty()) {
			kill += k;
			kill = kill % list.size();
			System.out.print(", " + list.remove(kill--));
		}
		System.out.print(">");
	}
}