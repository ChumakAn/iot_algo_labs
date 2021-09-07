package com.example.algo.lab1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class QuickSortTest {
    @Test
    public void testQuickSort(){
        String[] testInput = new String[]{"asc", "1", "5", "2", "34", "15"};
        QuickSort testSort = new QuickSort(testInput);
        testSort.quickSort();
         String actual = Arrays.toString(testSort.array);
         String expected = "[1, 2, 5, 15, 34]";
         assertEquals(expected, actual);
    }
    @Test
    public void testAscSortedArrayAsc(){
        String[] testInput = new String[]{"asc", "1", "2", "4", "10", "25"};
        QuickSort testSort = new QuickSort(testInput);
        testSort.quickSort();
        String actual = Arrays.toString(testSort.array);
        String expected = "[1, 2, 4, 10, 25]";
        assertEquals(expected, actual);
    }

    @Test
    public void testAscSortedArrayDesc(){
        String[] testInput = new String[]{"desc", "1", "2", "4", "10", "25" };
        QuickSort testSort = new QuickSort(testInput);
        testSort.quickSort();
        String actual = Arrays.toString(testSort.array);
        String expected = "[25, 10, 4, 2, 1]";
        assertEquals(expected, actual);
    }
    @Test
    public void testDescSortedDesc(){
        String[] testInput = new String[]{"desc", "25", "10", "4", "2", "1" };
        QuickSort testSort = new QuickSort(testInput);
        testSort.quickSort();
        String actual = Arrays.toString(testSort.array);
        String expected = "[25, 10, 4, 2, 1]";
        assertEquals(expected, actual);
    }
    @Test
    public void testDescSortedAsc(){
        String[] testInput = new String[]{"asc", "25", "10", "4", "2", "1" };
        QuickSort testSort = new QuickSort(testInput);
        testSort.quickSort();
        String actual = Arrays.toString(testSort.array);
        String  expected = "[1, 2, 4, 10, 25]";
        assertEquals(expected, actual);
    }
}
