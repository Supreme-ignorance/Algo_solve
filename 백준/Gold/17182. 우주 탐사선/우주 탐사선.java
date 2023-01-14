import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int K;
    static int[][] map;
    static int ideal = 0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++){
            ideal += 1 << i;
        }

        for (int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 중복 가능이니까 플루이드 워셜이야~
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }

        // 우선순위 구현
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.time - o2.time;
            }
        });

        pq.offer(new Node(K, 0, 1 << K));

        while (true){
            Node node = pq.poll();

            if (ideal == node.check){
                System.out.println(node.time);
                return;
            }

            for (int i = 0; i < N; i++){
                int temp = 1 << i;
                if ((temp & node.check) <= 0){
                    pq.offer(new Node(i, node.time + map[node.cur][i], node.check + temp));
                }
            }
        }
    }

    static class Node {
        int cur;
        int time;
        int check;

        public Node(int cur, int time, int check) {
            this.cur = cur;
            this.time = time;
            this.check = check;
        }
    }
}