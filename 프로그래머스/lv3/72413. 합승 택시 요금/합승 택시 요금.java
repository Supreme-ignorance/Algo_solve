import java.util.*;

class Solution {
    
    final static int LIMIT = 20000001;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] map = new int[n + 1][n + 1];
        
        for (int i = 0; i < n + 1; i++){
            Arrays.fill(map[i], LIMIT);
        }
        
        for (int i = 1; i < n + 1; i++){
            map[i][i] = 0;
        }
        
        for (int i = 0; i < fares.length; i++){
            map[fares[i][0]][fares[i][1]] = map[fares[i][1]][fares[i][0]] = fares[i][2];
        }
                                                             
        Floyd_Warshall(map);
        
        answer = check(s, a, b, map);
        
        return answer;
    }
    
    int check(int s, int a, int b, int[][] map){
        
        int ans = LIMIT;
        
        for (int i = 1; i < map.length; i++){
            int temp = map[s][i] + map[i][a] + map[i][b];
            ans = ans < temp ? ans : temp;
        }
        
        return ans;
        
    }
    
    void Floyd_Warshall(int[][] map){
        
        for (int m = 1; m < map.length; m++){
            for (int s = 1; s < map.length; s++){
                for (int e = 1; e < map.length; e++){
                    map[s][e] = map[s][e] < map[s][m] + map[m][e] ? map[s][e] : map[s][m] + map[m][e];
                }
            }
        }
        
    }
}