package Graphs;

import java.util.*;

public class ShortestPath {
    public static void main(String[] args) {
        //We will use BFS traversal because this traversal tells which nodes are closer to given node or which nodes are present at 1st level, 2nd level and so on
        //just we have to use one extra dist[] to store the distance from source node for every vertex
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        addEdges(adj, 0, 1);
        addEdges(adj, 0, 2);
        addEdges(adj, 1, 3);
        addEdges(adj, 1, 2);
        addEdges(adj, 2, 3);
        System.out.println(adj);
        dfsTraversal(adj, 0);
    }

    private static void dfsTraversal(List<List<Integer>> adj, int root) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root);
        boolean[] visited = new boolean[adj.size()];
        visited[root] = true;
        int[] dist = new int[adj.size()];
        dist[root] = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for(int i : adj.get(u)) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    dist[i] = dist[u] + 1;
                }
            }
        }
        Arrays.stream(dist).forEach(key -> System.out.println(key));
    }

    public static void addEdges(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
