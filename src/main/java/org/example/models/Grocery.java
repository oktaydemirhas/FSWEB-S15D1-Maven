package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public void startGrocery(){
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen 0, 1 veya 2 değerlerinden birini girin:");

        Scanner scanner = null;
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return;
            case 1:
                System.out.println("Eklenmesini istediğiniz elemanları giriniz (virgülle ayırın):");
                String addItems = scanner.nextLine();
                addItems(addItems);
                System.out.println("Grocery List: " + groceryList);
                break;
            case 2:
                System.out.println("Çıkarılmasını istediğiniz elemanları giriniz (virgülle ayırın):");
                String removeItems = scanner.nextLine();
                removeItems(removeItems);
                System.out.println("Grocery List: " + groceryList);
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen 0, 1 veya 2 girin.");
                break;
        }
        scanner.close();
    }

    public static void addItems(String input) {
        String[] itemsToAdd = input.split(",");
        for (String item : itemsToAdd) {
            String trimmedItem = item.trim();
            if (!checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            } else {
                System.out.println(trimmedItem + " zaten listede mevcut.");
            }
        }
        sortList();
    }

    public static void removeItems(String input) {
        String[] itemsToRemove = input.split(",");
        for (String item : itemsToRemove) {
            String trimmedItem = item.trim();
            if (checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
            } else {
                System.out.println(trimmedItem + " listede bulunamadı.");
            }
        }
        sortList();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        ArrayList<String> sortedList = new ArrayList<>(groceryList);
        Collections.sort(sortedList);
        System.out.println("Sıralı Grocery List: " + sortedList);
    }

    private static void sortList() {
        Collections.sort(groceryList);
    }
}
