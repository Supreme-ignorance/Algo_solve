class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int firstDpSize = triangle[triangle.length - 1].length + 1;
        
        int[] dp = new int[firstDpSize];
        
        answer = memoization(triangle, dp);
        
        return answer;
    }
    
    int memoization(int[][] triangle, int[] dp){
        
        for(int i = triangle.length - 1; i >= 0; i--){
            
            int[] newDp = new int[dp.length - 1];
            
            for (int j = 0; j < newDp.length; j++){
                
                int left = dp[j] + triangle[i][j];
                int right = dp[j + 1] + triangle[i][j];
                
                newDp[j] = left > right ? left : right;
            }
            
            dp = newDp;
        
        }
        
        return dp[0];
    }
}