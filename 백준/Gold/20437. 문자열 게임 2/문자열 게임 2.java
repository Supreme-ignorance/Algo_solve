import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        String[] inputs = new String[T];
        int[] nums = new int[T];

        for (int t = 0; t < T; t++){
            inputs[t] = br.readLine();
            nums[t] = Integer.parseInt(br.readLine());
        }

        for (int t = 0; t < T; t++){
            char[] input = inputs[t].toCharArray();

            int n = nums[t];
            
            if (n == 1){
                System.out.println(1 + " " + 1);
                continue;
            }
            
            int min = 10001;
            int max = -1;

            Queue<Integer>[] counter = new Queue[27];

            for (int i = 0; i < counter.length; i++){
                counter[i] = new LinkedList<>();
            }

            for (int i = 0; i < input.length; i++){
                int cur = input[i] - 'a';
                if (counter[cur].size() + 1 == n){
                    int front = counter[cur].poll();

                    min = min > i - front + 1? i - front + 1:min;
                    max = max < i - front + 1? i - front + 1:max;
                }

                counter[cur].add(i);
            }

            if (max != -1) {
                System.out.println(min + " " + max);
            } else {
                System.out.println(-1);
            }
        }
    }
}