import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		what_is(n, 0);
	}
	
	private static void what_is(int n, int m) {
		if (m == 0) System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		String[] qa = {"\"재귀함수가 뭔가요?\"", 
				"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.", 
				"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", 
				"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"", 
				"\"재귀함수가 뭔가요?\"", 
				"\"재귀함수는 자기 자신을 호출하는 함수라네\"", 
				"라고 답변하였지."};

		for (int i = 0; i < 4; i++) {
			final StringBuilder under = new StringBuilder();
			for (int j = 0; j < m; j++) {
				under.append("____");
			}
			under.append(qa[i]);
			final String unders_with_qa = under.toString();
			System.out.println(unders_with_qa);
		}
		
		if (n-1 != m) what_is(n, m+1);
		
		for (int i = 4; i < 7; i++) {
			final StringBuilder under = new StringBuilder();
			for (int j = 0; j < m+1; j++) {
				under.append("____");
			}
			under.append(qa[i]);
			final String unders_with_qa = under.toString();
			if (i < 6 && n-1 == m) System.out.println(unders_with_qa);
			if (i > 5) System.out.println(unders_with_qa);
		}
		
		if (m == 0) System.out.println(qa[6]);
	}
}