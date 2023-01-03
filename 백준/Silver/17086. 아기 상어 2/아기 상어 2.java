import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static Queue<Node> Q = new LinkedList<>();

    static int[] dr = { 0, 0, 1, -1, 1, -1, -1, 1 };
    static int[] dc = { 1, -1, 0, 0, 1, -1, 1, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        // 상어 위치 확인
        for (int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++){
                if (st.nextToken().equals("1")){
                    Q.add(new Node(r, c));
                    map[r][c] = -1;
                }
            }
        }

        int max = 0;
        int now = 0;
        // 안전 거리 확인
        while (!Q.isEmpty()){
            now++;
            int size = Q.size();
            for (int i = 0; i < size; i++){
                Node node = Q.poll();
                for (int j = 0; j < 8; j++){
                    int mr = node.r + dr[j];
                    int mc = node.c + dc[j];
                    if (mr >= 0 && mr < n && mc >= 0 && mc < m && map[mr][mc] == 0) {
                        map[mr][mc] = now;
                        max = now;
                        Q.add(new Node(mr, mc));
                    }
                }
            }
        }
        System.out.println(max);
    }

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}