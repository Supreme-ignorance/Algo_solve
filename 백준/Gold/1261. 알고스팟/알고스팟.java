import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        int[][] check = new int[N + 1][M + 1];

        // 벽 부수는 횟수 초기화
        for (int i = 0; i <= N; i++) {
            Arrays.fill(check[i], Integer.MAX_VALUE);
        }
        
        // 맵 만들기
        for (int r = 1; r <= N; r++){
            char[] line = br.readLine().toCharArray();
            for (int c = 1; c <= M ; c++){
                map[r][c] = line[c - 1] - '0';
            }
        }

        int ans = BFS(map, check, N, M);

        System.out.println(ans);
    }

    private static int BFS(int[][] map, int[][] check, int N, int M) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1, 1, 0));

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (true){
            Node node = pq.poll();

            if (check[node.r][node.c] <= node.value)
                continue;

            check[node.r][node.c] = node.value;

            // 탈출조건
            if (node.r == N && node.c == M)
                return node.value;

            for (int i = 0; i < 4; i++){
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                int nValue = node.value;

                if (nr < 1 || nr > N || nc < 1 || nc > M)
                    continue;

                // 벽을 부순다면
                if (map[nr][nc] == 1)
                    nValue++;

                pq.add(new Node(nr, nc, nValue));
            }
        }
    }

}

class Node implements Comparable<Node>{
    int r;
    int c;
    int value;

    public Node (int r, int c, int value){
        this.r = r;
        this.c = c;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}