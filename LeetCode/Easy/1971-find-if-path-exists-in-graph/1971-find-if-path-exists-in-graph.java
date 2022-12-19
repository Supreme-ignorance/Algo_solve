class Solution {

        static boolean[] visited;
        public boolean validPath(int n, int[][] edges, int source, int destination) {

            Map<Integer, List<Integer>> graph = new HashMap<>();
            visited = new boolean[n];

            for (int[] edge : edges) {
                int a = edge[0], b = edge[1];
                graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
                graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
            }


            return BFS(n, graph, source, destination);
        }

        public boolean BFS(int n, Map<Integer, List<Integer>> graph, int source, int destination){

            Queue<Integer> q = new LinkedList<>();

            q.offer(source);
            visited[source] = true;

            while (!q.isEmpty()){
                int top = q.poll();

                if (top == destination){
                    return true;
                }

                for (int node : graph.get(top)){
                    if (!visited[node]){
                        q.offer(node);
                        visited[node] = true;
                    }
                }
            }

            return false;
        }
    }