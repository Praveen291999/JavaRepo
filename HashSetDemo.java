package com.dnapass.training.java.Collections;  //Hashset does not allow duplicate elements.
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
public class HashSetDemo 
{
	public static void main(String[] args) 
{
// TODO Auto-generated method stub
// Create a empty hash set
		HashSet<String> colors = new HashSet<String>();
// use add() method to add values in the hash set
		colors.add("Red");
		colors.add("Green");
		colors.add("Black");
		colors.add("White");
		colors.add("Pink");
		colors.add("Yellow");
// print the hash set
System.out.println("The Hash Set: "+ colors);

//set Iterator
Iterator<String> p = colors.iterator();

// Iterate the hash set
while (p.hasNext())
{
	System.out.println(p.next());
}
System.out.println("Size of the Hash Set:"+ colors.size());
System.out.println("Checking the above array list is empty or not! "+colors.isEmpty());

//Remove all elements
colors.removeAll(colors); 

System.out.println("Hash Set after removing all the elements "+colors);

System.out.println("Checking the above array list is empty or not! "+colors.isEmpty());
HashSet<String> new_h_set = new HashSet <String>() ; 
new_h_set = (HashSet)colors;
System.out.println("Cloned Hash Set: " + new_h_set);

//Creating an Array 
String[] new_array = new String[colors.size()]; 
colors.toArray(new_array);


// Displaying Array elements 
System.out.println("Array elements: ");
for(String element : new_array)
{
System.out.println(element);
}

//Create a TreeSet of HashSet elements 
Set<String> tree_set = new TreeSet<String> (colors);

// Display TreeSet elements
System.out.println("TreeSet elements: ");
for(String element : tree_set) 
{
	System.out.println(element);
}


//Create a List from HashSet elements 
List<String> list = new ArrayList<String>(colors);

//Display ArrayList elements
System.out.println("ArrayList contains: "+ list);
HashSet<String>h_set2 = new HashSet<String>();
h_set2.add("Red");
h_set2.add("Pink");
h_set2.add("Black");
h_set2.add("Orange");
System.out.println("Second HashSet content: "+h_set2); 
colors. retainAll(h_set2);
System.out.println("HashSet content: "); 
System.out.println(colors);
colors.removeAll(h_set2);

// clear() method removes all the elements from a hash set
//_and the set becomes empty 
colors.clear();

//Display original hash set content again
System.out.println("HashSet content: "+colors);
HashSet<String> uniques = new HashSet<String>();
HashSet<String> dups = new HashSet<String>();
for (String a : args) 
	if (!uniques.add(a))
		dups.add(a);

// Destructive set-différence 
uniques.removeAll(dups);
System.out.println("Unique words: " + uniques); 
System.out.println("Duplicate words: " + dups);
Set<String> s = new HashSet<String>();
for (String a : args)
	s.add(a); 
System.out.println(s.size() + " distinct words: " + s);
}
}