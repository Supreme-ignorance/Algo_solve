import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> deck = new LinkedList<Integer>();
		
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			deck.offer(i);
		}
		
		while (!deck.isEmpty()) {
			if (deck.size() == 1) {
				System.out.println(deck.poll());
				break;
			}
			deck.poll();
			deck.offer(deck.poll());
		}
	}
}