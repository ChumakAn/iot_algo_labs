import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void testFindSolution1(){
        int expected = 3;
        int actual = Solution.findSolution("101101101",5);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testFindSolution2(){
        int expected = 1;
        int actual = Solution.findSolution("1111101", 5);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testFindSolution3(){
        int expected = 3;
        int actual = Solution.findSolution("110011011", 5);
        Assert.assertEquals(expected, actual);
    }

}
