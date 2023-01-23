import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        boolean[][] visited = new boolean[R][C];

        // map 입력받기
        for (int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = line.charAt(j);
            }
        }

        visited[R - 1][0] = true;
        int ans = DFS(R - 1, 0, map, visited, R, C, K, 1);

        System.out.println(ans);
    }

    private static int DFS(int r, int c, char[][] map, boolean[][] visited, int R, int C, int K, int cnt) {
        if (cnt > K) {
            return 0;
        }

        if (cnt == K && r == 0 && c == C - 1){
            return 1;
        }

        int temp = 0;

        for (int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C){
                continue;
            }
            if (visited[nr][nc] || map[nr][nc] == 'T'){
                continue;
            }

            visited[nr][nc] = true;
            temp += DFS(nr, nc, map, visited, R, C, K, cnt + 1);
            visited[nr][nc] = false;
        }

        return temp;
    }
}