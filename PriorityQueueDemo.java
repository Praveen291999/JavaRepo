package com.dnapass.training.java.Collections;

import java.util.*;
public class PriorityQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> colors = new PriorityQueue<String>();
		colors.add("Blue");
		colors.add("Red");
		colors.add("Green");
		colors.add("Yellow");
		colors.add("Black");
		colors.add("White");
		colors.add("Grey");
		System.out.println(colors);
		System.out.println(colors.peek());
		
		PriorityQueue<String> colors1 = new PriorityQueue<String>(colors);
		System.out.println(colors1);
		
		Set<String> hset= new HashSet<String>(colors);
		System.out.println(hset);
		TreeSet<String> tset= new TreeSet<String>(colors);
		System.out.println(tset);
		// Iterator tsetIter=tset.descendingIterator();
		LinkedList<String> ll1= new LinkedList<String>(colors);
		System.out.println(ll1);
		
		ArrayList<String> Al= new ArrayList<String>(colors);
		System.out.println(Al);
		
		//Deque <String> dq = ((Deque <String>)colors).clone();
	}

}
