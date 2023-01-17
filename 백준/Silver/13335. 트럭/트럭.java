import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] out = new int[W * N + 2];

        Queue<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            q.add(Integer.parseInt(st.nextToken()));
        }

        int onBridge = 0;
        int sec = 0;

        while(true){
            sec++;
            onBridge -= out[sec];

            if(onBridge == 0 && q.isEmpty()){
                System.out.println(sec);
                return;
            }

            if(!q.isEmpty() && L >= onBridge + q.peek()){
                onBridge += q.peek();
                out[sec + W] = q.poll();
            }
        }
    }
}