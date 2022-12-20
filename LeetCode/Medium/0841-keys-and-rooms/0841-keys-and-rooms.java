class Solution {

        int n;
        boolean[] isUnlock;
        Stack<Integer> s;
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            n = rooms.size();
            isUnlock = new boolean[n];
            s = new Stack<>();

            s.push(0);
            isUnlock[0] = true;

            return BFS(rooms);
        }

        public boolean BFS(List<List<Integer>> rooms) {
            while (!s.isEmpty()){
                int roomIdx = s.pop();
                List<Integer> room = rooms.get(roomIdx);

                for (int i = 0; i < room.size(); i++){
                    int key = room.get(i);
                    if (!isUnlock[key]){
                        s.push(key);
                        isUnlock[key] = true;
                    }
                }

                if (checkRooms()){
                    return true;
                }
            }

            return false;
        }

        public boolean checkRooms() {
            for (int i = 0; i < n; i++){
                if(!isUnlock[i]){
                    return false;
                }
            }

            return true;
        }
    }