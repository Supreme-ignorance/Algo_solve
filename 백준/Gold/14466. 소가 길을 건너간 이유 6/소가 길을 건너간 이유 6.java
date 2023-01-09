import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K, R;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] way = new int[N + 1][N + 1];
        int[][] cows = new int[K][2];

        for (int i = 1; i < N + 1; i++){
            Arrays.fill(way[i], Integer.parseInt("1111", 2));
        }

        for (int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            checkWay(a, b, c, d, way);
        }

        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cows[i][0] = a;
            cows[i][1] = b;
        }

        boolean[][] visited;
        int ans = 0;

        for (int i = 0; i < K; i++){
            visited = new boolean[N + 1][N + 1];
            move(cows[i][0], cows[i][1], way, visited);

            for (int j = i + 1; j < K; j++){
                if (!visited[cows[j][0]][cows[j][1]]){
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    private static void move(int r, int c, int[][] way, boolean[][] visited) {
        for (int i = 0; i < 4; i++){
            // 길
            if ((way[r][c] & (1 << i)) == 0)
                continue;

            int nr = r + dr[i];
            int nc = c + dc[i];

            // 범위
            if (nr < 1 || nr >= N + 1 || nc < 1 || nc >= N + 1)
                continue;
            // 이전에 방문
            if (visited[nr][nc])
                continue;

            visited[nr][nc] = true;
            move(nr, nc, way, visited);
        }
    }

    private static void checkWay(int a, int b, int c, int d, int[][] way) {

        if (c - a == dr[0]){
            way[c][d] -= 1 << 1;
            way[a][b] -= 1 << 0;
        } else if (c - a == dr[1]){
            way[c][d] -= 1 << 0;
            way[a][b] -= 1 << 1;
        } else if (d - b == dc[2]){
            way[c][d] -= 1 << 3;
            way[a][b] -= 1 << 2;
        } else if (d - b == dc[3]){
            way[c][d] -= 1 << 2;
            way[a][b] -= 1 << 3;
        }

    }
}