package com.example.algo.lab1;

import java.util.Arrays;

public class QuickSort {
    static int swapCounter = 0;
    static int comparisonCounter = 0;
    public String order;
    public int[] array;
    static long duration = 0;

    public QuickSort(String[] array) {
        this.order = array[0];
        this.array = new int[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            this.array[i - 1] = Integer.parseInt(array[i]);
        }
    }



    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        swapCounter++;
    }

    static int partition(int[] arr,String order, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            comparisonCounter++;
            if (order.equals("asc")) {
                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);

                }
            }  else if (order.equals("desc")){
                if (arr[j] >= pivot) {
                    i++;
                    swap(arr, i, j);

                }
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr,String order, int low, int high) {
        comparisonCounter++;
        if (low < high) {
            int pi = partition(arr,order, low, high);
            quickSort(arr, order,low, pi - 1);
            quickSort(arr,order, pi + 1, high);

        }
    }

    void quickSort(){
        long startTime = System.nanoTime();
        quickSort(array,order, 0, array.length - 1);
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

        QuickSort quickSort = new QuickSort(args);
        quickSort.quickSort();
        System.out.println(quickSort.toString());

    }
}
