import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] stack = new int[N];
            int[] check = new int[10001];

            for (int i = 0; i < N; i++){
                stack[i] = Integer.parseInt(st.nextToken());
                check[stack[i]] = i;
            }

            long ans = 0;

            for (int i = 0; i < N; i++){
                for (int j = 10000; j > stack[i]; j--){
                    if (check[j] > i){
                        ans += j - stack[i];
                        break;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}