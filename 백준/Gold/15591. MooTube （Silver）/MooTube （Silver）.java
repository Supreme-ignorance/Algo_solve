import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            graph[num1].add(new Node(num2, val));
            graph[num2].add(new Node(num1, val));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(check(k, v)).append("\n");
        }

        System.out.println(sb);
    }

    private static int check(int k, int v) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(v);

        int ans = 0;
        boolean[] visited = new boolean[N + 1];

        visited[v] = true;

        while (!pq.isEmpty()){
            int cur = pq.poll();

            for (Node node : graph[cur]){
                if (!visited[node.idx] && node.val >= k){
                    pq.offer(node.idx);
                    visited[node.idx] = true;
                    ans++;
                }
            }
        }

        return ans;
    }

    static class Node {
        int idx;
        int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}