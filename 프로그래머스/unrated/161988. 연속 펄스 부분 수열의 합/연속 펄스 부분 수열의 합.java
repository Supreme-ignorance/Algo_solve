class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long[][] dp = new long[2][sequence.length];
        
        int a = 1;
        int b = -1;
        
        dp[0][0] = -sequence[0];
        dp[1][0] = sequence[0];
        
        answer = answer > dp[0][0] ? answer : dp[0][0];
        answer = answer > dp[1][0] ? answer : dp[1][0];
        
        for (int i = 1; i < dp[0].length; i++){
            dp[0][i] = a * sequence[i] > a * sequence[i] + dp[0][i - 1] ?
                a * sequence[i] : a * sequence[i] + dp[0][i - 1];
            
            dp[1][i] = b * sequence[i] > b * sequence[i] + dp[1][i - 1] ?
                b * sequence[i] : b * sequence[i] + dp[1][i - 1];
            
            a *= -1;
            b *= -1;
            
            answer = answer > dp[0][i] ? answer : dp[0][i];
            answer = answer > dp[1][i] ? answer : dp[1][i];
        }
        
        return answer;
    }
}