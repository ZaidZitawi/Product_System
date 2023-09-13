package com.example.productsystemdatabase;

public class Gift implements Comparable<Gift> {
    public int promoter_ID;
    public String name;


    public Gift(int promoter_ID, String name) {
        this.promoter_ID = promoter_ID;
        this.name=name;
    }


    public void add(Gift p) {

    }

    @Override
    public int compareTo(Gift o) {
        return 0;
    }
}
