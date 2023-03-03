import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        int[] pockets = new int[K];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++){
            pockets[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, ((o1, o2) -> {
            return o1.weight - o2.weight;
        }));
        Arrays.sort(pockets);

        long ans = 0;
        PriorityQueue<Jewel> jewelPriorityQueue = new PriorityQueue<>();
        int pointer = 0;

        for (int i = 0; i < K; i++){

            while (pointer < N && jewels[pointer].weight <= pockets[i]){
                jewelPriorityQueue.add(jewels[pointer++]);
            }

            if (!jewelPriorityQueue.isEmpty())
                ans += jewelPriorityQueue.poll().value;
        }

        System.out.println(ans);
    }
}

class Jewel implements Comparable<Jewel>{
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Jewel o) {
        if (o.value != this.value)
            return o.value - this.value;
        else
            return this.weight - o.weight;
    }
}