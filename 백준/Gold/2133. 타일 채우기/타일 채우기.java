import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[31];

        arr[0] = 1;
        arr[1] = 0;
        arr[2] = 3;

        for (int i = 4; i <= 30; i++){
            arr[i] = 4 * arr[i - 2] - arr[i - 4];
        }

        System.out.println(arr[n]);
    }
}