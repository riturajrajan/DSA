package Graphs;

import java.util.*;

public class TopologicalSorting {
    //We can use any of the traversal. In BFS we will use indegree array and store the indegree of every nodes. In first we will check whose indegree in 0 it means
    //this nodes are independent and put it in queue. After putting in queue we will traverse through the adjacent vertex and reduce the indegree by 1.
    //If reducing of indegrree make it zero then again we push into queue.
    //For DFS we will go to the last vertex and put it in queue which means we reached last vertex and it is independent and return. After returning if again no
    //dfs call is there then we put it in queue. At end we pop and get topo sort
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        addEdges(adj, 0, 2);
        addEdges(adj, 0, 3);
        addEdges(adj, 1, 3);
        addEdges(adj, 1, 4);
        addEdges(adj, 2, 3);
        System.out.println(adj);
        int[] inDegree = findDegreeOfVertex(adj, 5);
        topologicalSorting(adj, inDegree);
    }

    private static void topologicalSorting(List<List<Integer>> adj, int[] inDegree) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.println(curr);
            for(int adjacent : adj.get(curr)) {
                inDegree[adjacent]--;
                if(inDegree[adjacent] == 0) queue.add(adjacent);
            }
        }
    }

    private static int[] findDegreeOfVertex(List<List<Integer>> adj, int V) {
        int[] inDegree = new int[V];
        for(int vertex = 0; vertex < V; vertex++) {
            for(int adjacent : adj.get(vertex)) {
                inDegree[adjacent]++;
            }
        }
        return inDegree;
    }


    public static void addEdges(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
}
