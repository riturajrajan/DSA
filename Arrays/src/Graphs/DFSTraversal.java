package Graphs;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {
    //We will start from given node and inside the list which means iterating on neighbour and then calling its neighbours. We will use extra array to check
    //which nodes are already visited and mark them visited.
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }
        addEdges(adj, 0, 1);
        addEdges(adj, 0, 2);
        addEdges(adj, 1, 3);
        addEdges(adj, 2, 3);
        addEdges(adj, 1, 4);
        addEdges(adj, 4, 5);
        boolean[] visited = new boolean[adj.size()];
        dfsTraversal(adj, 0, visited);
    }

    private static void dfsTraversal(List<List<Integer>> adj, int startNode, boolean[] visited) {
        visited[startNode] = true;
        System.out.print(startNode + " ");
        for(int connectedVertex : adj.get(startNode)) {
            if(!visited[connectedVertex]) {
                dfsTraversal(adj, connectedVertex, visited);
            }
        }
    }

    public static void addEdges(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
