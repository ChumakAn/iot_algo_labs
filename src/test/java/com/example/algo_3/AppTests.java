package com.example.algo_3;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AppTests {

    @Test
    void quickSortTest() {
        int[] testInput = new int[]{ 1, 5, 2, 34, 15};
        QuickSort testSort = new QuickSort(testInput);
        testSort.quickSort();
        String actual = Arrays.toString(testSort.array);
        String expected = "[1, 2, 5, 15, 34]";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testSortedArrayAsc(){
        int[] testInput = new int[]{ 1, 2, 4, 10, 25};
        QuickSort testSort = new QuickSort(testInput);
        testSort.quickSort();
        String actual = Arrays.toString(testSort.array);
        String expected = "[1, 2, 4, 10, 25]";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testDescSorted(){
        int[] testInput = new int[]{ 25, 10, 4, 2, 1};
        QuickSort testSort = new QuickSort(testInput);
        testSort.quickSort();
        String actual = Arrays.toString(testSort.array);
        String  expected = "[1, 2, 4, 10, 25]";
        Assertions.assertEquals(expected, actual);
    }
    @SneakyThrows
    @Test
    public void testGetResult()  {
        int[] testInput = new int[]{50, 20, 30, 17, 100};
        int testDiscount = 10;
        double actual = App.getMinSum(testInput,testDiscount);
        double expectedMinSum = 207.0;
        Assertions.assertEquals(expectedMinSum, actual);
    }
    @Test
    public void testGetTotalSum(){
        int[] testInput = new int[]{50, 20, 30, 17, 100};
        int actual = App.getTotalSum(testInput);
        int expected = 217;
        Assertions.assertEquals(expected, actual);
    }

}
