class Solution {
        public int rob(int[] nums) {

            int len = nums.length;

            if (len == 1){
                return nums[0];
            }

            int[] dp = new int[len];

            for(int i = 0; i < len; i++){

                int max = 0;

                for(int j = 0; j < i - 1; j++){
                    if (max < dp[j]){
                        max = dp[j];
                    }
                }

                dp[i] = max + nums[i];
            }

            if (dp[len - 1] > dp[len - 2]){
                return dp[len - 1];
            }
            return dp[len - 2];
        }
    }