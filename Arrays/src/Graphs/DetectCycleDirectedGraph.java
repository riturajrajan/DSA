package Graphs;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirectedGraph {
    public static void main(String[] args) {
        //Idea here is we will use two array, one for visited array and another for recursion stack. Anywhere we found that child is calling parent which means
        //both will be active in recursion stack at this point we can say that there is an cycle
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
        boolean[] recursionStack = new boolean[adj.size()];
        System.out.println(detectCycle(adj, visited, recursionStack, 0));
    }

    private static boolean detectCycle(List<List<Integer>> adj, boolean[] visited, boolean[] recursionStack, int vertex) {
       visited[vertex] = true;
       recursionStack[vertex] = true;
       for (int adjacent : adj.get(vertex)) {
           if(!visited[adjacent]) {
               if(detectCycle(adj, visited, recursionStack, adjacent)) return true;
           } else if(recursionStack[adjacent]) return true;
       }
       recursionStack[vertex] = false;
       return false;
    }

    public static void addEdges(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
