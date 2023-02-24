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
        int length = (int) Math.log10(num);

        int l = (int) Math.pow(10, length);
        int r = 1;

        while (l >= r){

            int left = num / l % 10;
            int right = num / r % 10;

            if (left != right){
                return false;
            }

            l /= 10;
            r *= 10;
        }

        return true;
    }

}