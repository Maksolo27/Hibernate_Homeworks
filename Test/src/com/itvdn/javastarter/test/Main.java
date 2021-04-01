package com.itvdn.javastarter.test;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        String[] array = {"Petya", "Vasya", "Kolya", "Sasha", "sasha"};

        System.out.println(Arrays.toString(array));

        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareToIgnoreCase(o1);
            }
        });

        System.out.println(Arrays.toString(array));
        int i = 10;

        if (i < 100) {
            //body
            System.out.println(i);
            i++;
        }

        int d = 10;

        while (i < 100) {
            System.out.println("Hello World!");
            i++;
        }

        for (int j = 10; j < 100; j++) {
            System.out.println(j);
        }

    }

}
