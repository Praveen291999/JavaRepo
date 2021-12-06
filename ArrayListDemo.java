package com.dnapass.training.java.Collections;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ArrayListDemo 
	{
		public static void main(String[] args) 
		{
// TODO Auto-generated method stub
			ArrayList<String> colors = new ArrayList<String>();
			colors.add("Red");
			colors.add("Green");
			colors.add("Orange");
			colors.add("White");
			colors.add("Black"); 
			System.out.println(colors);

// Print the list
			for (String element : colors) 
			{
				System.out.println(element);
			}

// Now insert a color at the first and last position of the list
colors.add(0, "Pink");
colors.add(5, "Yellow");
// Print the list
System.out.println(colors);

// Retrive the first and third element
String element = colors.get(0);
System.out.println("First element:" +element);
element = colors.get(2);
System.out.println("Third element: " + element);

//Update the third element with "Yellow
colors.set(2, "Yellow"); 

// Print the list again
System.out.println(colors);

//Remove the third element from the list. 
colors.remove(2); 

// Print the list again

System.out.println("After removing third element from the list:\n" + colors);

//Search the value Red
if (colors.contains ("Red")) 
{
	System.out.println("Found the element");
}
else 
{
	System.out.println("There is no such element");
}
Collections.sort(colors);
//Collections.sort((List<T>) new HashMap());
System.out.println("List after sort: " + colors);

List<String> List2 = new ArrayList<String>(); 
List2.add("A"); 
List2.add("B"); 
List2.add("C");
List2.add("D");
//Copy List2 to List1
Collections.copy(colors, List2); 
System.out.println("Copy List to List2, \nAfter copy: "+colors);


Collections. shuffle(colors);
System.out.println("List after shuffling:\n" + colors);


Collections.reverse(colors); 
System.out.println("List after reversing :\n" + colors);

List<String> sub_List = colors.subList(0, 3); 
System.out.println("List of first three elements: " + sub_List);

//Swapping 1st(index e) element with the 3rd (index 2) element
Collections. swap(colors, 0, 2); 
System.out.println("Array list after swap: ");
for (String b : colors) {
System.out.println(b);

ArrayList<String> c2 = new ArrayList<String>(); 
c2.add("Red");
c2.add("Green");
c2.add("Black"); 
c2.add("Pink");
System.out.println("List of second array: " + c2);
// Let join above two list
ArrayList<String> a = new ArrayList<String>();
a.addAll(colors);
a.addAll(c2);
System.out.println("New array:" +a);
ArrayList<String> newc1 = (ArrayList<String>) c2.clone();
System.out.println("Cloned array list: " + newc1);

colors.removeAll(colors);
System.out.println("Array list after remove all elements " + colors);
c2.trimToSize();
System.out.println(colors);
// Increase capacity to 6 
c2.ensureCapacity(6); 
c2.add("White");
c2.add("Pink");
c2.add("Yellow");

ArrayList<String> color = new ArrayList<String>();
color.add("Red");
color.add("Green");
System.out.println("Original array list: " + color);
String new_color = "White";
color.set(1, new_color);
int num = color.size(); 
System.out.println("Replace second element with 'White'.");
for (int i = 0; i < num; i++)
System.out.println(color.get(i));
}
}
}
