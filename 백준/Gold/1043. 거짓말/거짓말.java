import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int personNum = Integer.parseInt(st.nextToken());
        int partyNum = Integer.parseInt(st.nextToken());
        // 0번의 경우 거짓말을 할 수 없는 집합
        int[] parent = new int[personNum + 1];

        for (int i = 1; i < parent.length; i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        int knowNum = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < knowNum; i++){
            union(parent, 0, Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        int[][] partyPerson = new int[partyNum][];

        for (int i = 0 ; i < partyNum; i++){
            st = new StringTokenizer(br.readLine());

            int partyPersonNum = Integer.parseInt(st.nextToken());
            partyPerson[i] = new int[partyPersonNum];

            for (int j = 0; j < partyPersonNum; j++){
                partyPerson[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < partyPersonNum - 1; j++){
                union(parent, partyPerson[i][j], partyPerson[i][j + 1]);
            }

        }

        for (int i = 0 ; i < partyNum; i++){
            if (find(parent, partyPerson[i][0]) != 0)
                ans++;
        }

        System.out.println(ans);
    }

    static int find(int[] parent, int x){
        if (parent[x] == x)
            return x;
        else
            return find(parent, parent[x]);
    }

    static void union(int[] parent, int o1, int o2){
        int parent1 = find(parent, o1);
        int parent2 = find(parent, o2);
        
        if (parent1 < parent2){
            parent[parent2] = parent1;
        } else if (parent1 > parent2) {
            parent[parent1] = parent2;
        }
    }
}