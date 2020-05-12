package com.company.task6;

import java.io.*;
import java.util.*;


public class Main {
  public static ArrayList<Item> items = new ArrayList<>();
  public static ArrayList<Item> sack = new ArrayList<>();
  public static int capacity;
  public static int maxProfit;


      public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("This program solves \"0-1 Knapsack Problem\".");
        System.out.println("Enter the capacity of your knapsack (An integer greater than 0)");
        capacity = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter your data");
        System.out.println("Enter name weight and value (separated by space) of item 1");
        int n = 1 ;
        String s = bufferedReader.readLine();
        items.add(0,new Item("0",0,0)); // add blank item
        while (!s.equals("") ) {
            String[] a =  s.split(" ");
            items.add(new Item(a[0], Integer.parseInt(a[1]),Integer.parseInt(a[2]) ));
            n++;
            System.out.println("Enter name weight and value (separated by space) of item " + n + ". If you don't have next item, just press Enter");
            s = bufferedReader.readLine();
        }
        Collections.sort(items, new Comparator<Item>() {
              public int compare(Item i1, Item i2) {
                  return Integer.valueOf( i1.getWeight()).compareTo(i2.getWeight());
              }
          });  // sort items
        for (int i = 0 ; i<=  capacity; i++ ) {
              items.get(0).getProfits().add(0);
          }
        for (int i = 1 ; i<  items.size(); i++ ) {
             items.get(i).setProfits(capacity,   items.get(i-1).getProfits() );
          }
        for (Item i : items)   i.setMaxProfit();
        maxProfit = items.get(items.size()-1).getMaxProfit();
        System.out.println( " ANSWER : max profit is " + maxProfit );
        takeItems();
        System.out.println( " ANSWER : take next items :");
        printSack();
        printData();
        printMatrix();


    }
    public static void  takeItems(){
        int temp = maxProfit;
        int i = items.size()-1;
        int j = capacity;
        while (temp != 0 ){
            if ( items.get(i).getProfits().get(j) > items.get(i-1).getProfits().get(j)) {
                if (items.get(i).getValue()  <= temp) {
                    temp -= items.get(i).getValue();
                    items.get(i).setInclude(true);
                    i--;
                }
                else { j--; }
            }
            else i--; }

    }
    public static void printSack(){
        for (Item i : items ) {
            if (i.isInclude()) System.out.println(i.getName());
        }
    }
    public static void printData() {
        System.out.println( " ");
        System.out.println( " sorted items: " );
        for (Item i : items) {
            System.out.println("name=" + i.getName() + " weight=" + i.getWeight() + " value=" + i.getValue());
        }
    }
    public static void printMatrix(){
        System.out.println( " ");
        System.out.println( " calculated data " );
        System.out.print("p w ");
          for (int i =0 ; i<= capacity ; i ++){
              System.out.print(i + " ");

          }
        System.out.println();
        for (Item i : items ) {
            System.out.print(i.getValue() + " " + i.getWeight() + " ");
            for ( int q : i.getProfits())
                System.out.print(q + " ");


            System.out.println();
        }
    }
}
