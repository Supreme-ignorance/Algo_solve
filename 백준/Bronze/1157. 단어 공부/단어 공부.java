import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next().toUpperCase();
		
		List<Character> c = new ArrayList<>();
		int[] check = new int[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			if(c.isEmpty()) {
				c.add(str.charAt(i));
				check[c.size() - 1]++;
			} else {
				boolean ishave = false;
				for (int j = 0; j < c.size(); j++) {
					if (c.get(j) == str.charAt(i)) {
						ishave = true;
						check[j]++;
						break;
					}
				}
				if (!ishave) {
					c.add(str.charAt(i));
					check[c.size() - 1]++;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int idx = -1;
		boolean issame = false;
		
		for (int i = 0; i < c.size(); i++) {
			if (max < check[i]) {
				max = check[i];
				idx = i;
				issame = false;
			}
			else if (max == check[i]) issame = true;
		}
		
		System.out.println(issame? "?" : c.get(idx));
	}
}