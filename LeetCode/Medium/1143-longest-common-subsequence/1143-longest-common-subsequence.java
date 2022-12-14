class Solution {

        public int longestCommonSubsequence(String text1, String text2) {
            
            int length1 = text1.length();            
            int length2 = text2.length();


            int[][] dp = new int[length1 + 1][length2 + 1];
            
            for (int i = 0; i < length1; i++){
                for (int j = 0; j < length2; j++){
                    dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j) ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
            
            return dp[length1][length2];
        }
    }