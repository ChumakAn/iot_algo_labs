package com.example.algo_3;

import java.util.Arrays;

public class QuickSort {
    static int swapCounter = 0;
    static int comparisonCounter = 0;
    public int[] array;
    static long duration = 0;

    public QuickSort(int[] array) {
        this.array = array;
    }



    static void swap(int[] arr, int i, int j) {
        if(i!=j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            swapCounter++;
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            comparisonCounter++;

                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);

                }

            }

        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high) {
        comparisonCounter++;
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr,low, pi - 1);
            quickSort(arr, pi + 1, high);

        }
    }

    void quickSort(){
        long startTime = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        long endTime = System.nanoTime();
        duration = (endTime - startTime);
    }
    @Override
    public String toString() {
        return "QuickSort \n" +
                "Execution time: "+ duration+ " nanoseconds" +"\n"+
                "Comparisons: " + comparisonCounter+ "\n"+
                "Swaps: " + swapCounter + "\n"+
                "Result: " + Arrays.toString(array);
    }

    public static void main(String[] args) {


    }
}