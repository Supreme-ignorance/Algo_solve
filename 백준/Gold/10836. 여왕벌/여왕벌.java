import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] day = new int[n][3];
        int[] arr = new int[2 * m - 1];
        Arrays.fill(arr, 1);

        //매일매일
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            // 성장 크기
            for (int j = 0; j < 3; j++){
                day[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++){
            int cur = 2 * m - 2;
            for (int j = 2; j >= 0; ){
                if (day[i][j] > 0){
                    arr[cur] += j;
                    cur--;
                    day[i][j]--;
                } else {
                    j--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if (j == 0) {
                    sb.append(arr[m - 1 - i]).append(" ");
                } else {
                    sb.append(arr[m - 1 + j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}