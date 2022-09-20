import java.io.*;
import java.util.*;

public class Main {
	static Stack<Character> notation = new Stack<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static final int NUM = -99;
	static final int EMPTY = -89;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			infixtopostfix(str.charAt(i));
		}
		
		while (!notation.isEmpty()) {
			bw.append(notation.pop());
		}
		bw.flush();
	}
	
	static void infixtopostfix (char input) throws IOException {
		
		while (true) {
			int iv = checkvalue(input, false); // input value
			int tv = (notation.empty())? EMPTY : checkvalue (notation.peek(), true); // top value
			
			if (iv == NUM) {
				bw.append(input);
				break;
			} else if (tv == 0 && iv == 9) {
				notation.pop();
				break;
			} else if (iv > tv && iv != 9) {
				notation.add(input);
				break;
			} else if (iv <= tv || iv == 9) {
				bw.append(notation.pop());
			}
		}
	}
	
	static int checkvalue (char input, boolean isinstack) {
		if (input == '(' && isinstack) return 0;
		else if (input == '+' || input == '-') return 1;
		else if (input == '*' || input == '/') return 2;
		else if (input == '(') return 3;
		else if (input == ')') return 9;
		return NUM;
	}
}