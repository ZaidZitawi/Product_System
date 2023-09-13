package com.example.productsystemdatabase;

public class Customer {
        public int Customer_ID;
        public String Name;
        public int Age;
        public String PhoneNumber;
        public String Gender;
        int promoterid;
        int giftid;
        public Customer next;

        public Customer(int Customer_ID, String Name, int Age, String PhoneNumber, String Gender,int giftid, int promoterid) {

            this.Customer_ID =Customer_ID;
            this.Name=Name;
            this.Age= Age;
            this.PhoneNumber= PhoneNumber;
            this.Gender=Gender;
            this.giftid=giftid;
            this.promoterid=promoterid;
        }

    @Override
    public String toString() {
        return "Customer{"+ Customer_ID +" |  "+Name+"  | "+Age+" |   "+PhoneNumber+"  |  "+Gender+"  |  "+promoterid+"  |  "+giftid +'}';
    }
}
