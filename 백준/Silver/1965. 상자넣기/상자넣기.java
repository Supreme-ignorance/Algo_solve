import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;

        for (int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }

            if (max < dp[i]){
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}