package com.dnapass.training.java.day7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SwapTrans
{
public static void main(String[] args) 
{
// TODO Auto-generated method stub

//Create a list with items
List<Integer> list = Arrays.asList(44,55,99,77,88,66,33,22);
System.out.println("List before swapping: "+list);
Scanner sc = new Scanner(System.in);
System.out.print("Enter index i : ");
int i = sc.nextInt();
System.out.print("Enter index j : ");
int j = sc.nextInt();
Collections.swap(list, i, j);
System.out.println("List after swapping: "+list);
sc.close();
}
}
