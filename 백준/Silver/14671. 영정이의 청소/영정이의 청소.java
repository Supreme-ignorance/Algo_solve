import java.util.Scanner;

public class Main {

    static boolean[] check = new boolean[4];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        sc.nextInt();

        int n = sc.nextInt();

        //초기값 입력
        for (int i = 0; i < n; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();

            if(r % 2 == 0 && c % 2 == 0)
                check[0] = true;
            else if(r % 2 == 1 && c % 2 == 0)
                check[1] = true;
            else if(r % 2 == 0 && c % 2 == 1)
                check[2] = true;
            else if(r % 2 == 1 && c % 2 == 1)
                check[3] = true;
        }

        for(int i = 0; i < 4; i++){
            if(!check[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}