package Graphs;

import java.util.*;

public class BFSTraversal {
    //BFS traversal will be same as tree traversal just we have to make sure we don't print the same vertex 2 times so here we have to use one boolean[]
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        addEdges(adj, 0, 1);
        addEdges(adj, 0, 2);
        addEdges(adj, 1, 3);
        addEdges(adj, 1, 2);
        addEdges(adj, 2, 3);
        addEdges(adj, 2, 4);
        addEdges(adj, 3, 4);
        System.out.println(adj);
        dfsTraversal(adj, 0);
    }

    private static void dfsTraversal(List<List<Integer>> adj, int root) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root);
        Map<Integer, Boolean> map = new HashMap<>();   // we can use boolean array and that will be preferred because we want to see whether the node is visited or not
        // boolean[] visited = new boolean[adj.size()];
        //visited[root] = true;
        map.put(root, true);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.println(u + " ");
            for(int i : adj.get(u)) {
                if(!map.containsKey(i)) {      //if(!visited[i])
                    queue.add(i);
                    map.put(i, true);         // visited[i] = true
                }
            }
        }
    }

    public static void addEdges(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
