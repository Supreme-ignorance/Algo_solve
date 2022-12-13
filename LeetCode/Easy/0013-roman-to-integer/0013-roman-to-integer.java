class Solution {

        final static Map<Character, Integer> valueMap = Stream.of(new Object[][] {
                {' ', 0},
                {'I', 1},
                {'V', 5},
                {'X', 10},
                {'L', 50},
                {'C', 100},
                {'D', 500},
                {'M', 1000},
        }).collect(Collectors.toMap(item -> (Character) item[0], item -> (Integer)item[1]));

        char now;
        char prev;

        public int romanToInt(String s) {
            int ans = 0;
            now = ' ';
            prev = ' ';

            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < s.length(); i++){
                stack.push(s.charAt(i));
            }

            int i = 0;

            while (!stack.isEmpty()){
                now = stack.pop();

                if (checkSubtraction()){
                    ans -= valueMap.get(now);
                } else {
                    ans += valueMap.get(now);
                }

                prev = now;
            }

            return ans;
        }

        public boolean checkSubtraction() {

            if (valueMap.get(now) < valueMap.get(prev)){
                return true;
            }

            return false;
        }
    }