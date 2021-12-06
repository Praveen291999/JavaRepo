package com.dnapass.training.java.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
		public static void main(String[] args)
		{
			TreeSet<String> tree_set=new TreeSet<String>();
			tree_set.add("Red");
			tree_set.add("Green");
			tree_set.add("Orange");
			tree_set.add("White");
			tree_set.add("Black");
			System.out.println("Tree set:"+tree_set);
						
			//Print the tree list
			for(String element:tree_set)
			{
				System.out.println(element);
			}
			TreeSet<String> tree_set2=new TreeSet<String>();
			tree_set2.add("Pink");
			tree_set2.add("White");
			tree_set2.add("Black");
			System.out.println("Tree set:"+tree_set2);
			
			//adding tree2 to tree1
			tree_set.addAll(tree_set2);
			System.out.println("Tree set:"+tree_set);
			
			//Print list elements in reverse order
			Iterator it=tree_set.descendingIterator();
			System.out.println("Elelments in reverse order:");
			while(it.hasNext())
			{
				System.out.println(it.next());
			}
			
			//Find first element of treeset
			
			String firstElement=tree_set.first();
			System.out.println("First element is:"+firstElement);
			
			//Find last element of treeset
			
			String lastElement=tree_set.last();
			System.out.println("Last element is:"+lastElement);
			
			TreeSet<String> new_t_set=(TreeSet<String>)tree_set.clone();
			System.out.println("Cloned treeset:"+new_t_set);
			
			System.out.println("Size of the tree set:"+tree_set.size());
			
			TreeSet<Integer> tree_num=new TreeSet<Integer>();
			TreeSet<Integer> treeheadset=new TreeSet<Integer>();
			
			//add numbers in the tree
			tree_num.add(1);
			tree_num.add(2);
			tree_num.add(3);
			tree_num.add(4);
			tree_num.add(5);
			tree_num.add(6);
			tree_num.add(7);
			tree_num.add(8);
			tree_num.add(9);
			tree_num.add(10);
		
			//Find numbers less than 7
			treeheadset=(TreeSet)tree_num.headSet(7);
			
			//create an iterator
			
			Iterator ite=treeheadset.iterator();
			
			//displaying the treeset
			System.out.println("Tree set data:");
			while(ite.hasNext())
			{
				System.out.println(ite.next() + " ");
			}
			System.out.println("Greater than or equal to 86:"+tree_num.ceiling(86));
			System.out.println("Greater than or equal to 29:"+tree_num.ceiling(29));
			
			System.out.println("Lesser than or equal to 86:"+tree_num.floor(86));
			System.out.println("Lesser than or equal to 29:"+tree_num.floor(29));
			
			System.out.println("Strictly greater than 76:"+tree_num.higher(76));
			System.out.println("Strictly greater than 31:"+tree_num.higher(31));
			
			System.out.println("Strictly less than 69:"+tree_num.lower(69));
			System.out.println("Strictly less than 12:"+tree_num.lower(12));
			
			System.out.println("Removes the first(lowest) element:"+tree_num.pollFirst());
			System.out.println("Tree set after removing first element:"+tree_num);
			
			System.out.println("Removes the last element:"+tree_num.pollLast());
			System.out.println("Tree set after removing last element:"+tree_num);
			
			System.out.println("Removes the last element:"+tree_num.pollLast());
			System.out.println("Tree set after removing last element:"+tree_num);
			
			System.out.println("Removes 70 from the List:"+tree_num.remove(70));
			System.out.println("Tree set after removing last element:"+tree_num);
	}

}
