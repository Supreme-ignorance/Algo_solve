import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        test : for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++){
                if ((m & (1 << i)) == 0){
                    sb.append("#").append(t).append(" OFF\n");
                    continue test;
                }
            }

            sb.append("#").append(t).append(" ON\n");
        }

        System.out.println(sb);
    }
}