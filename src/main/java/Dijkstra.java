import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.*;

public class Dijkstra {

    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<Node> priorityQueue;
    private int numberOfVertices;
    List<List<Node>> adj;

    public Dijkstra(int numberOfVertices) {

        // This keyword refers to current object itself
        this.numberOfVertices = numberOfVertices;
        dist = new int[numberOfVertices];
        settled = new HashSet<>();
        priorityQueue = new PriorityQueue<>(numberOfVertices, new Node());
    }

    public void dijkstra(List<List<Node>> adj, int src) {
        this.adj = adj;
        for (int i = 0; i < numberOfVertices; i++)
            dist[i] = Integer.MAX_VALUE;

        priorityQueue.add(new Node(src, 0));
        dist[src] = 0;

        while (settled.size() != numberOfVertices) {
            if (priorityQueue.isEmpty())
                return;

            int u = priorityQueue.remove().node;

            if (settled.contains(u))
                continue;

            settled.add(u);

            e_Neighbours(u);
        }
    }

    private void e_Neighbours(int u) {

        int edgeDistance = -1;
        int newDistance = -1;

        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);

            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                priorityQueue.add(new Node(v.node, dist[v.node]));
            }
        }
    }

    public static List<List<Node>> fillAdjacencyList(int numberOfVertices) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            List<Node> item = new ArrayList<>();
            adj.add(item);
        }

        Integer[] arr = new Integer[Reader.dataForAdj.size()];
        arr = Reader.dataForAdj.toArray(arr);
        for (int i = 0; i < arr.length; i += 3) {
            adj.get(arr[i]).add(new Node(arr[i + 1], arr[i + 2]));
        }
        return adj;
    }

    public static Double countAveragePath(Dijkstra dpq) {
        double sum = 0;
        int quantity = 0;
        for (int i = 0; i < dpq.dist.length; i++) {
            sum += dpq.dist[i];
            if (dpq.dist[i] != 0) {
                quantity++;
            }
        }
        return Double.parseDouble(String.valueOf(sum / quantity));
    }

    public static void main(String args[]) throws IOException {
        Reader.readFromFile("src/main/java/dijkstra.in");
        int V = Reader.countDistinct();
        int source = Reader.source;

        List<List<Node>> adj = fillAdjacencyList(V);
        Dijkstra dpq = new Dijkstra(V);
        dpq.dijkstra(adj, source);

        System.out.println("The average path : " + Dijkstra.countAveragePath(dpq));

    }
}

