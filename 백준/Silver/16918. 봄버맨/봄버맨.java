import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, N;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        // 분류
        for (int r = 0; r < R; r++){
            String[] strArray = br.readLine().split("");

            for (int c = 0; c < C; c++){
                String cur = strArray[c];
                if (cur.equals(".") && map[r][c] != 2){
                    map[r][c] = -1;
                } else if (cur.equals("O")) {
                    map[r][c] = 0;
                }
            }
        }

        for (int day = 2; day <= N; day++){
            if (day % 2 == 0){
                putBomb(day);
            } else {
                // 3일이 되었다면 폭발
                for (int r = 0; r < R; r++){
                    for (int c = 0; c < C; c++){
                        if (map[r][c] == day - 3) {
                            blast(r, c);
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (map[r][c] != -1){
                    sb.append("O");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void blast(int r, int c) {
        for (int i = 0; i < 4; i++){
            int mr = r + dr[i];
            int mc = c + dc[i];

            if (mr >= 0 && mr < R && mc >= 0 && mc < C && map[r][c] != map[mr][mc])
                map[mr][mc] = -1;
        }

        map[r][c] = -1;
    }

    private static void putBomb(int day) {
        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (map[r][c] == -1) {
                    map[r][c] = day;
                }
            }
        }
    }
}