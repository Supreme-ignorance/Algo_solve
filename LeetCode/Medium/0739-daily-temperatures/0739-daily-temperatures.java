class Solution {
        public int[] dailyTemperatures(int[] temperatures) {

            // 위치 저장
            int[] dp = new int[101];
            int[] ans = new int[temperatures.length];

            for (int i = temperatures.length - 1; i >= 0; i--) {
                int target = temperatures[i];
                dp[target] = i;

                int min = Integer.MAX_VALUE;
                for (int j = target + 1; j < 101; j++){
                    if (i < dp[j] && min > dp[j]){
                        min = dp[j];
                    }
                }

                ans[i] = min == Integer.MAX_VALUE ? 0 : min - i;
            }

            return ans;
        }
    }