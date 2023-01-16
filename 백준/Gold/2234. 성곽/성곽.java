import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, area;
    static boolean[][] visited;
    static List<Integer> sizes = new ArrayList<>();
    static List<List<Integer>> close = new ArrayList<>();

    static int[] dc = {-1, 0, 1, 0};
    static int[] dr = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        area = new int[N][M];
        visited = new boolean[N][M];
        sizes.add(0);
        close.add(new ArrayList<>());

        // input
        for (int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 구역 나누기
        int max = divide();

        System.out.println(sizes.size() - 1);
        System.out.println(max);

        max = Integer.MIN_VALUE;

        for(int i = 1; i < sizes.size(); i++){
            for(int j = 0; j < close.get(i).size(); j++){
                max = Math.max(max, sizes.get(i) + sizes.get(close.get(i).get(j)));
            }
        }

        System.out.println(max);

    }

    private static int divide() {
        // 인접한 방을 넣을 배열
        close.add(new ArrayList<>());
        // 가장 넒은 방 크기
        int max = Integer.MIN_VALUE;
        // 넘버링 숫자
        int cnt = 1;
        for (int r = 0; r < N; r++){
            for (int c = 0; c < M; c++){
                if (visited[r][c]) continue;
                visited[r][c] = true;
                area[r][c] = cnt;
                int size = numbering(r, c, cnt);
                cnt++;
                max = Integer.max(max, size);
                sizes.add(size);
                close.add(new ArrayList<>());
            }
        }

        return max;
    }

    private static int numbering(int r, int c, int cnt) {
        int size = 1;

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            // 벽이 존재하지 않다면
            if ((map[r][c] & 1 << i) <= 0) {

                if (visited[nr][nc]) continue;

                area[nr][nc] = cnt;
                visited[nr][nc] = true;
                size += numbering(nr, nc, cnt);

            } else if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] && area[nr][nc] != cnt){
                close.get(cnt).add(area[nr][nc]);
            }
        }

        return size;
    }
}