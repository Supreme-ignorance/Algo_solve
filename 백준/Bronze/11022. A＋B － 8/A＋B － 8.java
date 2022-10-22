import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.valueOf(br.readLine());

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int res = a + b;

            bw.append("Case #" + i + ": " + a + " + " + b + " = "+ res + "\n");
        }

        bw.flush();
    }
}