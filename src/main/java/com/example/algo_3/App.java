package com.example.algo_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class App {
    private static final String DISCNT_IN = "discnt.in";
    private static final String DISCNT_OUT = "discnt.out";
    private static final Random RANDOM = new Random();


    private static int[] readPrices() throws IOException {
        List<Integer> arrayList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(App.DISCNT_IN))) {
            String line = bufferedReader.readLine();
            for (String number : line.split(" ")) {
                arrayList.add(Integer.parseInt(number));
            }
        }
        return arrayList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int readDiscount() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(App.DISCNT_IN))) {
            bufferedReader.readLine();
            return Integer.parseInt(bufferedReader.readLine());
        }
    }

    public static double getMinSum(int[] products, int discount) throws IOException {
        QuickSort quickSort = new QuickSort(products);
        quickSort.quickSort();
        products = quickSort.array;

        int quantityProductsWithDiscount = products.length / 3;

        double result = 0;
        {
            int i = products.length - 1;
            while (i >= products.length - quantityProductsWithDiscount) {
                result += (1 - (double) discount / 100) * products[i];
                i--;
            }
        }
        int i = products.length - quantityProductsWithDiscount - 1;
        while (i >= 0) {
            result += products[i];
            i--;
        }
        return result;
    }
    public static int getTotalSum(int[] products) {
        int sum = 0;
        for (int product : products) {
            sum += product;
        }
        return sum;
    }
    private static void generateRandomPricesAndDiscount(int quantityOfProducts) throws IOException {
        try (FileWriter fileWriter = new FileWriter(App.DISCNT_IN)) {
            for (int i = 0; i < quantityOfProducts; i++) {
                fileWriter.write(RANDOM.nextInt(1000) + " ");
            }
            fileWriter.write("\n" + RANDOM.nextInt(100));
        }
    }


    private static void writeResult(String fileName, double minSum) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(BigDecimal.valueOf(minSum).setScale(2, RoundingMode.HALF_UP).toString());
        }
    }

    public static void main(String[] args) throws IOException {
        generateRandomPricesAndDiscount(11);
        int[] products = readPrices();
        int discount = readDiscount();
        double minSum = getMinSum(products, discount);
        int sum = getTotalSum(products);
        writeResult(DISCNT_OUT, minSum);
        System.out.println(minSum);
        System.out.println(sum);
    }
}
