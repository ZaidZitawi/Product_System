package com.example.productsystemdatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class LinkedList<T extends Comparable<T>> {
    private Node<T> head;

    public void insert(T data) {
        Node<T> add = new Node<T>(data), prev = null, curr = head;

        for (; curr != null && curr.getData().compareTo(data) < 0; prev = curr, curr = curr.getNext())
            ;

        if (head == null) {
            head = add;
        } else if (curr == head) {
            add.setNext(head);
            head = add;
        } else {
            add.setNext(curr);
            prev.setNext(add);
        }

    }

    public void insert(@SuppressWarnings("unchecked") T... arr) {
        for (int i = 0; i < arr.length; i++)
            insert(arr[i]);

    }

    public void insertNotSorted(@SuppressWarnings("unchecked") T... arr) {
        for (int i = arr.length - 1; i >= 0; i--) {

            Node<T> add = new Node<T>(arr[i]);

            if (head == null) {
                head = add;
            } else {
                add.setNext(head);
                head = add;
            }
        }

    }

    public Node<T> search(T data) {
        Node<T> curr = head;
        while (curr != null) {
            if (curr.getData().equals(data))
                return curr;
            curr = curr.getNext();
        }
        return curr;
    }

    public void remove(T data) {
        Node<T> prev = null, curr = head;

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        for (; curr != null && !curr.getData().equals(data); prev = curr, curr = curr.getNext())
            ;

        if (curr == null) {
            System.out.println("Not Exist !");
        } else {
            prev.setNext(curr.getNext());
        }
    }

    public int length() {
        return length(head);
    }

    private int length(Node<T> curr) {
        if (curr == null)
            return 0;
        else
            return 1 + length(curr.getNext());
    }

    @Override
    public String toString() {
        return "Head" + " -> " + head;
    }

    public void addAt(int x, T data) throws IndexOutOfBoundsException {
        int count = 0;
        Node<T> curr = head;
        while (curr != null && count++ < x)
            curr = curr.getNext();

        if (curr == null)
            throw new IndexOutOfBoundsException("Index Out Of Bound");

        curr.setData(data);

    }

    public T max() {
        Node<T> curr = head;
        T max = curr.getData();
        while (curr != null) {
            if (max.compareTo(curr.getData()) < 0)
                max = curr.getData();
            curr = curr.getNext();
        }
        return max;
    }

    public T min() {
        Node<T> curr = head;
        T max = curr.getData();
        while (curr != null) {
            if (max.compareTo(curr.getData()) > 0)
                max = curr.getData();
            curr = curr.getNext();
        }
        return max;
    }

    public void deleteDuplicate() {
        deleteDuplicate(head);
    }

    private void deleteDuplicate(Node<T> curr) {
        if (curr == null || curr.getNext() == null)
            return;
        if (curr.getData().equals(curr.getNext().getData())) {
            curr.setNext(curr.getNext().getNext());
            deleteDuplicate(curr);
        } else
            deleteDuplicate(curr.getNext());

    }

    public void exchangeTwoLinkedList(LinkedList<T> arr1) {
        Node<T> pointer = head;
        head = arr1.head;
        arr1.head = pointer;
    }

    public void deleteNotSortedDuplicate() {
        deleteNotSortedDuplicate(head, head, head.getNext());
    }

    private void deleteNotSortedDuplicate(Node<T> curr, Node<T> prev1, Node<T> curr1) {
        if (curr1 == null && curr == null)
            return;
        else if (curr1 == null && curr.getNext() != null && curr.getNext().getNext() != null) {
            deleteNotSortedDuplicate(curr.getNext(), curr.getNext(), curr.getNext().getNext());
            return;
        } else if (curr1 == null) {
            return;
        }

        if (curr.getData().equals(curr1.getData())) {
            prev1.setNext(curr1.getNext());
            deleteNotSortedDuplicate(curr, prev1, curr1.getNext());
        } else
            deleteNotSortedDuplicate(curr, curr1, curr1.getNext());

    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getHead() {
        return head;
    }
}




























//public class LinkedList {
//    public Customer front, back;
//    public Promoter front1, back1;
//    int size, size1;
//
//    public LinkedList() {//empty list
//        this.front = null;
//        this.back = null;
//        this.size = 0;
//    }
//
////    public LinkedList(Customer front, Customer back, Promoter front1, Promoter back1, int size, int size1) {
////        this.front = front;
////        this.back = back;
////        this.front1 = front1;
////        this.back1 = back1;
////        this.size = size;
////        this.size1 = size1;
////    }
//
//    public void addFirst(int Customer_ID, String FirstName, String LastName, int Age, String PhoneNumber, String Gender) {
//        Customer newStudent = new Customer(Customer_ID, FirstName, LastName, Age, PhoneNumber, Gender);
//        newStudent.next=front;
//        front = newStudent;
//        Customer s = front;
//        while (s.next != null) {
//            s = s.next;
//        }
//        back = s;
//        size++;
//    }
//
//    @Override
//    public String toString() {
//        Customer newStudent = front;
//        String buffer = "";
//        while (newStudent != null) {
//            buffer = buffer.concat(newStudent.toString());
//            newStudent = newStudent.next;
//        }
//        return buffer;
//    }
//
//    public void deleteLast(){
//        Customer current=front;
//        if(size==0)
//            return;
//        else if(size==1)
//            front=back=null;
//        else {
//            for (int i = 0; i < size - 2; i++) {// the current reaches the node which is before the last one....size()-1 reaches the last one
//                current = current.next;
//            }
//            current.next=null;
//            back.next=current;
//        }
//        size--;
//    }
//    public void deleteFirst(){
//        if(size==0)
//            return;
//        else if(size==1)
//            front=back=null;
//        else
//            front=front.next;
//        size--;
//    }
//
//    public void delete(int index){
//        Customer current=front;
//        if(size==0)
//            return;//empty linkedlist
//        else if (index==0)
//            deleteFirst();
//        else if (index==size-1)
//            deleteLast();
//        else if (index>0&&index<size-1){
//            for(int i=0;i<index-1;i++)//the same as size-2, it will lead to the previous node from the one wanted to delete
//                current=current.next;
//            current.next=current.next.next;
//        }
//        size--;
//    }
//    public int SearchPOS(int CID){//Delete Position of the node
//        Customer  current=front;
//        int POS=0;
//        while (current!=null){
//            if (current.Customer_ID==CID)
//                return POS;
//            else
//                current=current.next;
//            POS+=1;
//        }
//        size--;
//        return -1;
//    }
//    public Customer Search(int CID){//search for node according to seatNum and print its attributes
//        Customer  current=front;
//        while (current!=null){
//            if (current.Customer_ID==CID)
//                return current;
//            else
//                current=current.next;
//        }
//        return null;
//    }
//    public void Update(Customer C, int Customer_ID, String FirstName, String LastName, int Age, String PhoneNumber, String Gender) {
//        Search(Customer_ID);
//        C.Customer_ID=Customer_ID;
//        C.FirstName=FirstName;
//        C.LastName=LastName;
//        C.Age=Age;
//        C.PhoneNumber=PhoneNumber;
//        C.Gender=Gender;
//    }
////===================================================================================================================//
//
//
//    public void PaddFirst(int Promoter_ID, String FirstName, String LastName, int Age, String PhoneNumber, String Gender) {
//        Promoter newPromoter = new Promoter(Promoter_ID, FirstName, LastName, Age, PhoneNumber, Gender);
//        newPromoter.next=front1;
//        front1 = newPromoter;
//        Promoter s = front1;
//        while (s.next != null) {
//            s = s.next;
//        }
//        back1 = s;
//        size++;
//    }
//
//    public String PtoString() {
//        Promoter newPromoter = front1;
//        String buffer = "";
//        while (newPromoter != null) {
//            buffer = buffer.concat(newPromoter.toString());
//            newPromoter = newPromoter.next;
//        }
//        return buffer;
//    }
//
//    public void PdeleteLast(){
//        Promoter current=front1;
//        if(size==0)
//            return;
//        else if(size==1)
//            front1=back1=null;
//        else {
//            for (int i = 0; i < size - 2; i++) {// the current reaches the node which is before the last one....size()-1 reaches the last one
//                current = current.next;
//            }
//            current.next=null;
//            back1.next=current;
//        }
//        size--;
//    }
//    public void PdeleteFirst(){
//        if(size==0)
//            return;
//        else if(size==1)
//            front1=back1=null;
//        else
//            front1=front1.next;
//        size--;
//    }
//
//    public void Pdelete(int index){
//        Promoter current=front1;
//        if(size==0)
//            return;//empty linkedlist
//        else if (index==0)
//            PdeleteFirst();
//        else if (index==size-1)
//            PdeleteLast();
//        else if (index>0&&index<size-1){
//            for(int i=0;i<index-1;i++)//the same as size-2, it will lead to the previous node from the one wanted to delete
//                current=current.next;
//            current.next=current.next.next;
//        }
//        size--;
//    }
//    public int PSearchPOS(int PID){//Delete Position of the node
//        Promoter current=front1;
//        int POS=0;
//        while (current!=null){
//            if (current.Promoter_ID==PID)
//                return POS;
//            else
//                current=current.next;
//            POS+=1;
//        }
//        size--;
//        return -1;
//    }
//    public Promoter PSearch(int PID){//search for node according to seatNum and print its attributes
//        Promoter current=front1;
//        while (current!=null){
//            if (current.Promoter_ID==PID)
//                return current;
//            else
//                current=current.next;
//        }
//        return null;
//    }
//    public void PUpdate(Promoter P, int Promoter_ID, String FirstName, String LastName, int Age, String PhoneNumber, String Gender) {
//        Search(Promoter_ID);
//        P.Promoter_ID=Promoter_ID;
//        P.FirstName=FirstName;
//        P.LastName=LastName;
//        P.Age=Age;
//        P.PhoneNumber=PhoneNumber;
//        P.Gender=Gender;
//    }
//}