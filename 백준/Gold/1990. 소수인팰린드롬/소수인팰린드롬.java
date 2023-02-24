import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] isPrimeNumber = new boolean[b + 1];

        Arrays.fill(isPrimeNumber, true);

        // 소수 판별, 아리스토텔레스의 채
        for (int i = 2; i <= b; i++){

            // 소수가 아니면 넘긴다.
            if (!isPrimeNumber[i]){
                continue;
            }

            // 펠린드롬 체크
            if (i >= a && PalindromeCheck(i)){
                sb.append(i).append("\n");
            }

            // 채에 거른다.
            for (int j = 2 * i; j <= b; j += i){
                isPrimeNumber[j] = false;
            }

        }

        sb.append(-1);

        System.out.println(sb.toString());
    }

    private static boolean PalindromeCheck(int num) {
    	int p = 0;
    	for(int i = num; i > 0; i /= 10){
    		p *= 10;
    		p += i % 10;
    	}
    	if(p == num) return true;
    	return false;
    }

}