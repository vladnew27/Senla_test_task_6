package com.company.task6;

import java.util.ArrayList;

import java.util.Collections;

public class Item {
    private String name;
    private int weight;
    private int value;
    private boolean isInclude;
    private int maxProfit;
    private ArrayList<Integer> profits = new ArrayList<Integer>();

    public int getMaxProfit() {
        return maxProfit;
    }
    public void setMaxProfit() {
        this.maxProfit = Collections.max(this.profits);
    }
    public ArrayList<Integer> getProfits() {
        return profits;
    }
    public void setProfits(ArrayList<Integer> profits) {
        this.profits = profits;
    }
    public Item(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
     public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }
    public int getValue() {
        return value;
    }
    public boolean isInclude() {
        return isInclude;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setInclude(boolean include) {
        isInclude = include;
    }
    public void setProfits (int capacity, ArrayList<Integer> profits0){
        this.profits.add(0,0);
        for (int i = 1; i<=capacity; i++){
            if (this.weight > i ) profits.add(i,  profits0.get(i));
            else if (i - this.weight < 0 )  profits.add(i, Math.max(  this.value , profits0.get(i)));
            else profits.add(i, Math.max(  this.value +  profits0.get(i - this.weight),profits0.get(i))); // max( this.include and this.not include)
        }
    }

}
