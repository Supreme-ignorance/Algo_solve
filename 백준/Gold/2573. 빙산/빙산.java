import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int[][] map;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        // 맵 입력받기
        for (int r = 0; r < R; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int lump;
        int year = 0;

        while (true){
            lump = check();

            if (lump != 1)
                break;

            yearPasses();

            year++;
        }

        if (lump == 0){
            System.out.println(0);
        } else {
            System.out.println(year);
        }
    }

    private static void yearPasses() {
        int[][] newMap = new int[R][C];

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (map[r][c] != 0){

                    int cnt = 0;

                    for (int i = 0; i < 4; i++){
                        int mr = r + dr[i];
                        int mc = c + dc[i];

                        cnt = map[mr][mc] == 0 ? cnt + 1 : cnt;
                    }

                    newMap[r][c] = 0 > map[r][c] - cnt ? 0 : map[r][c] - cnt;
                }
            }
        }

        map = newMap;
    }

    private static int check() {
        boolean[][] check = new boolean[R][C];
        int lump = 0;

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){

                if (!check[r][c]){
                    if (map[r][c] == 0){
                        check[r][c] = true;
                    } else {
                        dfsCheck(r, c, check);
                        lump++;
                    }
                }

            }
        }

        return lump;
    }

    private static void dfsCheck(int r, int c, boolean[][] check) {
        if (!check[r][c]){
            check[r][c] = true;

            for (int i = 0; i < 4; i++){
                int mr = r + dr[i];
                int mc = c + dc[i];

                if (mr < 0 || mr >= R || mc < 0 || mc >= C || map[mr][mc] == 0)
                    continue;

                dfsCheck(mr, mc, check);
            }
        }
    }
}