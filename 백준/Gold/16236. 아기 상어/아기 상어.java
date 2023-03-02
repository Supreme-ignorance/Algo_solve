import java.io.*;
import java.util.*;

public class Main {
    static int sharkSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        int sr = -1;
        int sc = -1;
        sharkSize = 2;

        for (int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());

                if (map[r][c] == 9){
                    sr = r;
                    sc = c;
                    map[r][c] = 0;
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int ans = BFS(map, pq, N, sr, sc, 0, 0);

        System.out.println(ans);
    }

    private static int BFS(int[][] map, PriorityQueue<Node> pq, int N, int cr, int cc, int fish, int ans) {

        boolean[][] check = new boolean[N][N];

        pq.add(new Node(cr, cc, 0));
        check[cr][cc] = true;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        while (!pq.isEmpty()){
            Node node = pq.poll();

            if (map[node.r][node.c] < sharkSize && map[node.r][node.c] > 0){
                pq.clear();
                map[node.r][node.c] = 0;
                fish++;

                if (sharkSize == fish){
                    fish = 0;
                    sharkSize++;
                }

                return BFS(map, pq, N, node.r, node.c, fish, ans + node.time);
            }

            for (int i = 0; i < 4; i++){
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || check[nr][nc])
                    continue;

                if (map[nr][nc] > sharkSize)
                    continue;

                pq.add(new Node(nr, nc, node.time + 1));
                check[nr][nc] = true;
            }
        }

        return ans;
    }

}

class Node implements Comparable<Node>{
    int r;
    int c;
    int time;

    public Node (int r, int c, int time){
        this.r = r;
        this.c = c;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {

        if (this.time != o.time)
            return this.time - o.time;
        else if (this.r != o.r)
            return this.r - o.r;
        else
            return this.c - o.c;
    }
}