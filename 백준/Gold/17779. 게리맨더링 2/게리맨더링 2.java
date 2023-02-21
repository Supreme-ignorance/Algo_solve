import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, total, min;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        total = 0;

        for(int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < n; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                total += map[r][c];
            }
        }

        min = Integer.MAX_VALUE;

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                gerrymandering(r, c);
            }
        }

        System.out.println(min);
    }

    private static void gerrymandering(int r, int c) {
        boolean[][] lines;
        int[] sum;

        for(int d1 = 1; d1 < n - 2; d1++){
            if (c - d1 < 0)
                break;
            for(int d2 = 1; d2 < n - 2; d2++){
                if (r + d1 + d2 >= n || c + d2 >= n)
                    break;

                lines = new boolean[n][n];
                sum = new int[5];

                for (int i = 0; i <= d1; i++){
                    lines[r + i][c - i] = true;
                    lines[r + d2 + i][c + d2 - i] = true;
                }

                for (int i = 0; i <= d2; i++){
                    lines[r + i][c + i] = true;
                    lines[r + d1 + i][c - d1 + i] = true;
                }

                // 1 구역 인구수
                for (int i = 0; i < r + d1; i++) {
                    for (int j = 0; j <= c; j++) {
                        if (lines[i][j]) break;
                        sum[0] += map[i][j];
                    }
                }

                // 2 구역 인구수
                for (int i = 0; i <= r + d2; i++) {
                    for (int j = n - 1; j > c; j--) {
                        if (lines[i][j]) break;
                        sum[1] += map[i][j];
                    }
                }

                // 3 구역 인구수
                for (int i = r + d1; i < n; i++) {
                    for (int j = 0; j < c - d1 + d2; j++) {
                        if (lines[i][j]) break;
                        sum[2] += map[i][j];
                    }
                }

                // 4 구역 인구수
                for (int i = r + d2 + 1; i < n; i++) {
                    for (int j = n - 1; j >= c - d1 + d2; j--) {
                        if (lines[i][j]) break;
                        sum[3] += map[i][j];
                    }
                }

                // 5 구역 인구수
                sum[4] = total;

                for (int i = 0; i < 4; i++) {
                    sum[4] -= sum[i];
                }

                // 정렬
                Arrays.sort(sum);

                // 최대 - 최소
                min = Math.min(min, sum[4] - sum[0]);
            }
        }
    }
}