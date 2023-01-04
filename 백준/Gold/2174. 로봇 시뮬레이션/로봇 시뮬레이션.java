import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a, b, n, m;

    static int[] dx = { 0, 1, 0, -1};
    static int[] dy = { 1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int[][] map = new int[a + 1][b + 1];

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 0은 가로 1은 세로 2는 방향
        int[][] condition = new int[n + 1][3];

        //경계조건
        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            map[x][y] = i;
            condition[i][0] = x;
            condition[i][1] = y;
            condition[i][2] = dirToNum(dir);
        }
        
        //명령입력
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int cur = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            switch (command){
                case "L":
                    condition[cur][2] -= num;
                    while(condition[cur][2] < 0){
                        condition[cur][2] += 4;
                    }
                    break;
                case "R":
                    condition[cur][2] += num;
                    condition[cur][2] %= 4;
                    break;
                case "F":
                    for(int j = 1; j <= num; j++){
                        int nx = condition[cur][0] + j * dx[condition[cur][2]];
                        int ny = condition[cur][1] + j * dy[condition[cur][2]];
                        if(nx <= 0 || nx >= a + 1 || ny <= 0 || ny >= b + 1){
                            System.out.println("Robot " + cur + " crashes into the wall");
                            return;
                        } else if(map[nx][ny] != 0){
                            System.out.println("Robot " + cur + " crashes into robot " + map[nx][ny]);
                            return;
                        }
                    }
                    int temp = map[condition[cur][0]][condition[cur][1]];
                    map[condition[cur][0]][condition[cur][1]] = 0;
                    condition[cur][0] += num * dx[condition[cur][2]];
                    condition[cur][1] += num * dy[condition[cur][2]];
                    map[condition[cur][0]][condition[cur][1]] = temp;
                    break;
            }
        }

        System.out.println("OK");
    }

    private static int dirToNum(String dir) {
        if(dir.equals("W")){
            return 3;
        } else if(dir.equals("N")){
            return 0;
        } else if(dir.equals("E")){
            return 1;
        } else if(dir.equals("S")){
            return 2;
        };

        return -1;
    }
}