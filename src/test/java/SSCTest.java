import org.junit.Assert;
import org.junit.Test;

public class SSCTest {
    @Test
    public void testSSC(){
        Graph g1 = new Graph(5);

        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println("SSC in first graph ");
        g1.SCC();
        String actualString = String.valueOf(Graph.resultString);
        String expectedString = "4" + " " +
                "\n" +
                "3" + " " +
                "\n" +
                "1 2 0" + " " +
                "\n";

        Assert.assertEquals(expectedString, actualString);
    }
}
