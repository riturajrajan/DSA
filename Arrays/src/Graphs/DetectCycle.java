package Graphs;

import java.util.ArrayList;
import java.util.List;

public class DetectCycle {
    //We can use any of the traversal, here we are using DFS traversal so, concept will remain same just we need to add one more parameter which is parent
    //we need to pass parent in every recursion call and anywhere we see the node is visited and it is not the parent of current node it means cycle is there.
    //We need to pass -1 as the parent for the first starting node
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        addEdges(adj, 0, 1);
        addEdges(adj, 1, 3);
        addEdges(adj, 1, 2);
        addEdges(adj, 2, 3);
        System.out.println(adj);
        boolean[] visited = new boolean[adj.size()];
        System.out.println(detectCycle(adj, -1, 0, visited));
    }

    private static boolean detectCycle(List<List<Integer>> adj, int parent, int vertex, boolean[] visited) {
        visited[vertex] = true;
        for(int adjency : adj.get(vertex)) {
            if(!visited[adjency]) {
                if(detectCycle(adj, vertex, adjency, visited)) {
                    return true;
                }
            } else if(vertex != parent) return true;
        }
        return false;
    }

    public static void addEdges(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
