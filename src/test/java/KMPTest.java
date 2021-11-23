import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class KMPTest {
    @Test
    public void testKMP() {
        String pattern = "VLAD";
        int pLength = pattern.length();
        String actual = Arrays.toString(KMP.createPrefixArray(pattern, pLength));
        String expected = "[0, 0, 0, 0]";

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testKMPPrefix() {
        String pattern = "AABACG";
        int pLength = pattern.length();
        String actual = Arrays.toString(KMP.createPrefixArray(pattern, pLength));
        String expected = "[0, 1, 0, 1, 0, 0]";

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testKMPSearch(){
        String pattern = "AABACG";
        String text = "DSAEAATRAABACG";
        String actual = KMP.KMPSearch(pattern,text).toString();
        String expected = "Found pattern at index 8\n";
        Assert.assertEquals(expected,actual);
    }

}
