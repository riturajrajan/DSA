package Graphs;

import java.util.*;

public class BFSDisconnectedGraphs {
    //It will be same as BFS traversal but we need to create one wrapper class which will pass the visited[] array to DFS. So lets say 0, 1, 2, 3 are connected and
    //4, 5, 6 are connected so when i = 0 is called all the reachable nodes will be printed and if called for i = 1, 2, 3 then simply this will be ignored because
    //visited[1 or 2 or 3] will be ignored ana again loop starts for i = 4 and rest disconnected nodes will be printed.
    //Time Complexity is O(V + E) E because we need to traverse every element in the 0 element all arraylist and V because may be all the nodes are disconnected
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
        dfsDisconnectedTraversal(adj);
    }

    private static void dfsDisconnectedTraversal(List<List<Integer>> adj) {
        int count = 0;     //we can also find how many different components are there which means disconnected graph
        boolean[] visited = new boolean[adj.size()];
        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                dfsTraversal(adj, i, visited);
                count++;
            }
        }
    }

    private static void dfsTraversal(List<List<Integer>> adj, int root, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root);
        visited[root] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.println(u + " ");
            for(int i : adj.get(u)) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true ;
                }
            }
        }
    }

    public static void addEdges(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
