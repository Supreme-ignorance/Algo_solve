import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static int xNum = 0;
	static int oNum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			// map 초기화
			map = new char[3][3];

			String temp = br.readLine();

			if (temp.equals("end"))
				return;

			int idx = 0;
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					map[r][c] = temp.charAt(idx++);
				}
			}
			
			if (checkNum() && checkgoal())
				System.out.println("valid");
			else
				System.out.println("invalid");
		}
	}

	private static boolean checkgoal() {
		int xVertiGoal = 0;
		int oVertiGoal = 0;
		int xwidGoal = 0;
		int owidGoal = 0;
		int xdiagGoal = 0;
		int odiagGoal = 0;
		int xreversediagGoal = 0;
		int oreversediagGoal = 0;
		
		int xdiag = 0;
		int odiag = 0;
		int xreversediag = 0;
		int oreversediag = 0;
		for (int r = 0; r < 3; r++) {
			int xVerti = 0;
			int oVerti = 0;
			int xwid = 0;
			int owid = 0;
			for (int c = 0; c < 3; c++) {
				if (map[r][c] == 'X')
					xVerti++;
				else if (map[r][c] == 'O')
					oVerti++;
				
				if (map[c][r] == 'X')
					xwid++;
				else if (map[c][r] == 'O')
					owid++;
				
				if (r == c) {
					if (map[r][c] == 'X')
						xdiag++;
					else if (map[r][c] == 'O')
						odiag++;
				}
				
				if (r + c == 2) {
					if (map[r][c] == 'X')
						xreversediag++;
					else if (map[r][c] == 'O')
						oreversediag++;
				}
			}
			
			if (xVerti >= 3)
				xVertiGoal++;
			if (oVerti >= 3)
				oVertiGoal++;
			if (xwid >= 3)
				xwidGoal++;
			if (owid >= 3)
				owidGoal++;
		}
		
		if (xdiag >= 3)
			xdiagGoal++;
		if (odiag >= 3)
			odiagGoal++;
		if (xreversediag >= 3)
			xreversediagGoal++;
		if (oreversediag >= 3)
			oreversediagGoal++;
		
		int xGoal = xVertiGoal + xwidGoal + xdiagGoal + xreversediagGoal;
		int oGoal = oVertiGoal + owidGoal + odiagGoal + oreversediagGoal;
		
		if (xVertiGoal >= 2 || xwidGoal >= 2 || xwidGoal >= 2 || oVertiGoal >= 2 || owidGoal >= 2 || owidGoal >= 2) {
			return false;
		}
		
		if (xGoal >= 1 && oGoal >= 1) {
			return false;
		}
		
		if (xGoal == 0 && oGoal == 0) {
			return isfull();
		}
		if (oGoal >= 1 && xNum != oNum) {
			return false;
		}
		if (xGoal >= 1 && xNum == oNum) {
			return false;
		}
		
		return true;
	}

	private static boolean isfull() {
		int num = 0;
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (map[r][c] == '.')
					num++;
			}
		}
		
		if (num == 0)
			return true;
		return false;
	}

	private static boolean checkNum() {
		xNum = 0;
		oNum = 0;

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (map[r][c] == 'X')
					xNum++;
				else if (map[r][c] == 'O')
					oNum++;
			}
		}

		if (xNum == oNum || xNum == oNum + 1) {
			return true;
		}
		return false;
	}

}