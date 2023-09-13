package com.example.productsystemdatabase;

public class Promoter implements Comparable<Promoter> {
    public int Promoter_ID;
    public String Name;
    public int Age;
    public String PhoneNumber;
    public String Gender;
    public Promoter next;

    public Promoter(int promoter_ID, String name, int age, String phoneNumber, String gender) {
        Promoter_ID = promoter_ID;
        Name = name;
        Age = age;
        PhoneNumber = phoneNumber;
        Gender = gender;
    }

    @Override
    public String toString() {
        return "Promoter{"+ Promoter_ID +" |  "+Name+"  | "+Age+" |   "+PhoneNumber+"  |  "+Gender+"  |  " + "'}'";
    }

    @Override
    public int compareTo(Promoter o) {
        return this.Promoter_ID - o.Promoter_ID;
    }

    public void add(Promoter p) {

    }
}
