package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShortestPathDAG {
    public static void main(String[] args) {
        //Idea here is we can use any of the standard algo like Dijkstra's but topoSort is having less time complexity is O(V+E). We will find the topoSort
        //and iterate over the stack element and will create a dist[] which contains the dist of all vertex from source node. Initially we will assign
        //infinite value and if we find minimum value then we update the dist[]
        List<List<Pair>> adj = new ArrayList<>();
        int totalVertex = 6;
        for(int i = 0; i < totalVertex; i++) {
            adj.add(new ArrayList<>());
        }
        addEdges(adj, 0, new Pair(1, 2));
        addEdges(adj, 0, new Pair(4, 1));
        addEdges(adj, 4, new Pair(2, 2));
        addEdges(adj, 1, new Pair(2, 3));
        addEdges(adj, 2, new Pair(3, 6));
        addEdges(adj, 4, new Pair(5, 4));
        addEdges(adj, 5, new Pair(3, 1));
        ArrayDeque<Integer> topoSort = new ArrayDeque<Integer>();
        //Print adjacency list
        for(int i = 0; i < adj.size(); i++) {
            String connected = adj.get(i).stream().map(Pair::toString).collect(Collectors.joining(","));
            System.out.println(i + ": " + connected);
        }
        shortestPathDAG(adj, totalVertex, topoSort);
    }

    private static void shortestPathDAG(List<List<Pair>> adj, int totalVertex, ArrayDeque<Integer> topoSort) {
        boolean[] visited = new boolean[totalVertex];
        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                dfsTraversal(adj, i, visited, topoSort);
            }
        }
        //Now start finding the shortestPath
        int[] dist = new int[totalVertex];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int source = 1;
        dist[source] = 0;
        System.out.println(topoSort);
        while (!topoSort.isEmpty()) {
            int vertex = topoSort.pop();
            if (dist[vertex] != Integer.MAX_VALUE) { // Only consider reachable vertices
                for (Pair adjacent : adj.get(vertex)) {
                    if (dist[adjacent.vertex] > dist[vertex] + adjacent.weight) {
                        dist[adjacent.vertex] = dist[vertex] + adjacent.weight;
                    }
                }
            }
        }
        Arrays.stream(dist).forEach(key -> System.out.println(key));
    }

    private static void dfsTraversal(List<List<Pair>> adj, int node, boolean[] visited, ArrayDeque<Integer> topoSort) {
        visited[node] = true;
        for(Pair adjacent : adj.get(node)) {
            if(!visited[adjacent.vertex]) {
                dfsTraversal(adj, adjacent.vertex, visited, topoSort);
            }
        }
        topoSort.push(node);
    }

    public static void addEdges(List<List<Pair>> adj, int u, Pair v) {
        adj.get(u).add(v);
    }
}

class Pair {
    int vertex;
    int weight;

    public Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + vertex + ", " + weight + ")";
    }
}