import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Stack<int[]> stack = new Stack<>();
		Stack<int[]> stacklow = new Stack<>();
		
		int[][] arr = new int[n][2];
		
		int top = 0;
		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			top = Math.max(arr[i][1], top);
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
			}
		});
		
		for (int i = 0; i < n; i++) {
			stack.add(arr[i]);
		}
		int start = 0;
		int max = 0;
		int res = 0;
		boolean istop = false;
		int topcodi = 0;
		int end = 0;
		
		while (!stack.isEmpty() || !stacklow.isEmpty()) {
			if (!istop) {
				start = stack.peek()[0];
				max = Math.max(stack.peek()[1], max);
				if (max == top) {
					istop = true;
					topcodi = start;
					max = 0;
					continue;
				}
				stack.pop();
				end = stack.peek()[0];
				res += max * (start - end);
				
			} else {
				while (!stack.isEmpty()) {
					stacklow.add(stack.pop());
				}
				start = stacklow.peek()[0];
				max = Math.max(stacklow.pop()[1], max);
				if (max == top) {
					res += max * (topcodi - start + 1);
					break;
				}
				if(!stacklow.isEmpty()) end = stacklow.peek()[0];
				res += max * (end - start);
			}
		}
		System.out.println(res);
	}
}