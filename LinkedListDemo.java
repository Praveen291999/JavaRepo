package com.dnapass.training.java.Collections;

import java.util.*;
public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> link=new LinkedList<Integer>();
		link.add(10);
		link.add(20);
		link.add(40);
		link.add(80);
		link.add(2, 11);
		link.add(11);
		link.add(10);
		link.add(100);
		link.add(17);
		link.add(22);
		
		System.out.println(link.offer(9999));
		
		System.out.println(link);
		Iterator llIter = link.descendingIterator();
		while(llIter.hasNext()) {
			System.out.println(llIter.next());
		}
		System.out.println("peek :"+link.peek());
		System.out.println("Sublist :"+link.subList(2, 5));
		
		Set<Integer> hset= new HashSet<Integer>(link);
		System.out.println(hset);
		Set<Integer> tset= new TreeSet<Integer>(link);
		System.out.println(tset);
		Iterator tsetIter= tset.iterator();
	}

}
