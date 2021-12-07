package com.dnapass.training.java.day5;
     //Accept a string, and two indices(integers), and print the substring ,start,end.
import java.util.Scanner;
public class Substring 
{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string:");
        String S = in.nextLine();
        System.out.println("Start string:");
        int start = in.nextInt();
        System.out.println("End string:");
        int end = in.nextInt();
        System.out.println(S.substring(start,end));
    }
}