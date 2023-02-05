import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[T + 2];

        for (int i = 1; i <= T; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            for (int j = i + time; j <= T + 1; j++){
                dp[j] = dp[j] > dp[i] + money ? dp[j] : dp[i] + money;
            }
        }

        System.out.println(dp[T + 1]);
    }
}