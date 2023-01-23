import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      StringTokenizer st = new StringTokenizer(br.readLine());

        String S = br.readLine();
        String P = br.readLine();

        int idx = 0;
        int ans = 0;

        for(int i = 0; i < P.length(); i++){
            if (S.indexOf(P.substring(idx, i+1)) != -1) {
                continue;
            }
            ans++;
            idx = i;
        }
        
        // idx가 마지막글자를 가리킬때 세지않는다.
        ans++;

        // 망함

//        Set<String> set = new HashSet<>();
//
//        for(int i = 0; i < S.length(); i++){
//            for(int j = 1; j <= S.length() - i; j++){
//                set.add(S.substring(i, i + j));
//            }
//        }
//
//        int ans = 0;
//
//        for(int i = 0; i < P.length(); ){
//            ans++;
//
//            if(i == P.length() -1){
//                break;
//            }
//
//            for(int j = 1; j <= P.length() - i; j++){
//                if(!set.contains(P.substring(i, i + j))){
//                    i += j - 1;
//                    break;
//                }
//            }
//        }

        System.out.println(ans);
    }
}