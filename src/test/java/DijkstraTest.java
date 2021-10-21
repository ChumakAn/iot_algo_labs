import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DijkstraTest {

    @Test
    public void testCountAveragePath(){
        Reader.readFromFile("src/main/java/dijkstra.in");
        int V = Reader.countDistinct();
        int source = Reader.source;

        List<List<Node>> adj = Dijkstra.fillAdjacencyList(V);
        Dijkstra dpq = new Dijkstra(V);
        dpq.dijkstra(adj, source);
        Double actual = Dijkstra.countAveragePath(dpq);
        Double expected = 9.4;
        Assert.assertEquals(expected,actual);
    }
}
