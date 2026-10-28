package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

// Starter for Search Inventory Map (Workbook 3a, Section 4-1 Using a HashMap, Exercise 2).
// main is done: it asks for a product id and looks it up in the map.
// Your job is loadInventory(): put products in the map, the product id as the key.
public class SearchInventoryMap {

    public static HashMap<Integer, Product> inventory =
            new HashMap<Integer, Product>();

    public static void main(String[] args) {
        // this method loads product objects into inventory
        loadInventory();
        Scanner scanner = new Scanner(System.in);
        System.out.print("What item # are you interested in? ");
        int id = scanner.nextInt();
        Product matchedProduct = inventory.get(id);
        if (matchedProduct == null) {
            System.out.println("We don't carry that product");
        } else {
            System.out.printf("We carry %s and the price is $%.2f",
                    matchedProduct.getName(), matchedProduct.getPrice());
        }
    }

    private static void loadInventory(){
        // Your code should be here
        try {
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
            String csvLine;

            while((csvLine = reader.readLine()) != null){
                String[] tokens = csvLine.split("\\|");

                int productID = Integer.parseInt(tokens[0]);
                String productName = tokens[1];
                double productPrice = Double.parseDouble(tokens[2]);

                inventory.put(productID, new Product(productID, productName, productPrice));



            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

