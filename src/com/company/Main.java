package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int n = 10;

        int weightsCollection[] = new int[n];

        for (int i = 0; i < n; i++) {
            weightsCollection[i] = random.nextInt(100);
        }
        System.out.println("Веса людей не отсортированные: ");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-5d", weightsCollection[i]);
        }

        System.out.println();

        int temp;
        int offset = 0;
        boolean isSort;

        do {
            isSort = true;

            for (int i = 0; i < n - 1 - offset; i++) {
                if (weightsCollection[i + 1] < weightsCollection[i]) { // поменять знак и поиск изменится от большего к меньшему
                    isSort = false;

                    temp = weightsCollection[i];
                    weightsCollection[i] = weightsCollection[i + 1];
                    weightsCollection[i + 1] = temp;
                }
            }

            offset++;
        } while (isSort == false);

        System.out.println("Веса людей отсортированные: ");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-5d", weightsCollection[i]);
        }
        System.out.println();

        System.out.print("Введите вес для поиска: ");
        int searchWeight = input.nextInt();
        int searchIndex = -1;

        int leftIdex = 0;
        int rightIndex = n - 1;
        int middleIdex;

        while (rightIndex - leftIdex > 1) {

            middleIdex = (leftIdex + rightIndex) / 2;
            if (weightsCollection[middleIdex] == searchWeight){
                searchIndex = middleIdex;
                break;
            } else if (weightsCollection[middleIdex] < searchWeight){
             leftIdex = middleIdex;
            }else if (weightsCollection[middleIdex] > searchWeight){
                rightIndex = middleIdex;
            }
        }


        System.out.printf("Первый человек с весом %d имеет индекс: %d", searchWeight, searchIndex);

        /* System.out.print("Введите вес для поиска: ");
        int searchWeight = input.nextInt();
        int searchIndex = -1;

        for (int i = 0; i < n; i++) {
           if (weightsCollection[i] == searchWeight){
               searchIndex = i;
               break;
           }
        }
        System.out.printf("Первый человек с весом %d имеет индекс: %d",searchWeight,searchIndex);*/
    }
}
