package edu.cscc;

import java.io.IOException;
import java.util.Arrays;

//Tristan DeMaria, Lab #14, 5/3/21
//Program is meant to receive an array of names and sort them alphabetically,
//then select the top 5 names and print them.
//Program also compares times of two methods of sorting: bubble sort and
//the built-in array.sort method.

public class Main {

    private static final String SERFNAME = "bigsurnames.ser";

    public static void main(String[] args) {

        String[] surnames;

        try {
            surnames = CensusData.deserialize(SERFNAME);
            System.out.println("Unsorted array of "+surnames.length+" names");
            top5names(surnames);
            System.out.println("=========================");

            System.out.println("Sort array with Bubble Sort");
            long start = System.currentTimeMillis();
            BubbleSort.sort(surnames);
            long stop = System.currentTimeMillis();
            System.out.println("Elapsed time: "+(stop-start)+" milliseconds");
            top5names(surnames);
            System.out.println("=========================");

            surnames = CensusData.deserialize(SERFNAME);
            System.out.println("Sort array with Java built-in sort");
            start = System.currentTimeMillis();
            Arrays.sort(surnames);
            stop = System.currentTimeMillis();
            System.out.println("Elapsed time: "+(stop-start)+" milliseconds");
            top5names(surnames);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Cannot read file "+SERFNAME);
        }
    }

    public static void top5names(String[] names) {
        System.out.println("Top 5 names in list");
        for (int i=0; i<5; ++i) {
            System.out.println(names[i]);
        }
    }
}
