import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double treeHeight = Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int treeSize = (int) Math.pow(2, treeHeight);

        tree = new long[treeSize];

        long[] arr = new long[N + 1];

        for (int i = 1; i < N + 1; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        initTree(1, 1, N, arr);

        int limit = M + K;

        for (int i = 0; i < limit; i++){
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            switch (command){
                case 1 :
                    int target = Integer.parseInt(st.nextToken());
                    long value = Long.parseLong(st.nextToken());

                    updateTree(1, 1, N, target, value, arr);
                    arr[target] = value;
                    break;
                case 2 :
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken());

                    long ans = sumTree(1, 1, N, left, right);

                    sb.append(ans).append("\n");
            }

        }

        System.out.println(sb);
    }

    private static long sumTree(int node, int st, int ed, int left, int right) {
        if(ed < left || st > right){
            return 0;
        }else if (left <= st && ed <= right){
            return tree[node];
        } else {
            return sumTree(2 * node, st, (st + ed) / 2, left, right)
            + sumTree(2 * node + 1, (st + ed) / 2 + 1, ed, left, right);
        }
    }

    private static void updateTree(int node, int st, int ed, int target, long value, long[] arr) {

        if (st <= target && target <= ed){
            tree[node] += value;
            tree[node] -= arr[target];

            if (st != ed){
                updateTree(2 * node, st, (st + ed) / 2, target, value, arr);
                updateTree(2 * node + 1, (st + ed) / 2 + 1, ed, target, value, arr);
            }
        }

    }

    private static long initTree(int node, int st, int ed, long[] arr) {

        if (st == ed){
            return tree[node] = arr[st];
        } else {
            return tree[node] = initTree(node * 2, st, (st + ed) / 2, arr)
                                + initTree(node * 2 + 1, (st + ed) / 2 + 1, ed, arr);
        }

    }

}