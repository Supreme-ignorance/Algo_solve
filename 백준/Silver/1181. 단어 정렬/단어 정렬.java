import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		Set<String> word = new HashSet<String>();

		for (int i = 0; i < n; i++) {
			word.add(sc.next());
		}
		
		String[] list = word.toArray(new String[0]);
		
		Arrays.sort(list, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length()) {
					return o1.length() - o2.length();
				} else return o1.compareTo(o2);
			}
		});
		
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
	
	
}