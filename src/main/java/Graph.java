
import java.util.*;

class Graph {


    private final int numberOfVertices;


    private LinkedList<Integer>[] adjacencyList;
    private int time;
    static StringBuilder resultString = new StringBuilder();

    @SuppressWarnings("unchecked")
    Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyList = new LinkedList[numberOfVertices];

        for (int i = 0; i < numberOfVertices; ++i)
            adjacencyList[i] = new LinkedList();

        time = 0;
    }

    void addEdge(int currentVertex, int neighbourVertex) {
        adjacencyList[currentVertex].add(neighbourVertex);
    }


    StringBuilder SCCUtil(int nextVertex, int[] low, int[] discoveryTime,
                 boolean[] isStackMember,
                 Stack<Integer> connectedAncestors) {

        discoveryTime[nextVertex] = time;
        low[nextVertex] = time;
        time += 1;
        isStackMember[nextVertex] = true;
        connectedAncestors.push(nextVertex);
        int vertex;

        Iterator<Integer> i = adjacencyList[nextVertex].iterator();

        while (i.hasNext()) {
            vertex = i.next();

            if (discoveryTime[vertex] == -1) {

                SCCUtil(vertex, low, discoveryTime, isStackMember, connectedAncestors);
                low[nextVertex] = Math.min(low[nextVertex], low[vertex]);
            } else if (isStackMember[vertex]) {

                low[nextVertex] = Math.min(low[nextVertex], discoveryTime[vertex]);
            }
        }


        int vertexToPop = -1;
        if (low[nextVertex] == discoveryTime[nextVertex]) {
            while (vertexToPop != nextVertex) {
                vertexToPop = (int) connectedAncestors.pop();
                resultString.append(vertexToPop).append(" ");
                isStackMember[vertexToPop] = false;
            }
            resultString.append("\n");
        }
        return resultString;
    }

    void SCC() {

        int[] discoveryTime = new int[numberOfVertices];
        int[] low = new int[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            discoveryTime[i] = -1;
            low[i] = -1;
        }

        boolean[] stackMember = new boolean[numberOfVertices];
        Stack<Integer> st = new Stack<>();


        for (int i = 0; i < numberOfVertices; i++) {
            if (discoveryTime[i] == -1)
                SCCUtil(i, low, discoveryTime,
                        stackMember, st);
        }

    }


    public static void main(String[] args) {

    }
}

