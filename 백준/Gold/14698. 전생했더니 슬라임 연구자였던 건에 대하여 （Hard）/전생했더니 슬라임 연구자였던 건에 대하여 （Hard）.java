import java.io.*;
import java.util.*;

public class Main {

    final static long LIMIT = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스
        for (int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());

            // 입력 받기
            for (int i = 0; i < N; i++){
                pq.add(Long.parseLong(st.nextToken()));
            }

            long energy = 1;

            // 반복
            while (pq.size() > 1){
                long newSlime = pq.poll() * pq.poll();

                pq.add(newSlime);

                energy = (newSlime % LIMIT) * energy;
                energy %= LIMIT;
            }

            sb.append(energy).append("\n");
        }

        System.out.println(sb.toString());
    }

}