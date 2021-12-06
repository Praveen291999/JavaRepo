package com.dnapass.training.java.Collections;

import java.util.*;
import java.util.Map.Entry;
public class TreeMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		TreeMap<Integer ,String> tmap= new TreeMap<Integer,String>();
		tmap.put(0,"Hello");
		tmap.put(1, "There");
		tmap.put(2, "How");
		tmap.put(3, "Are");
		tmap.put(4, "You");
		tmap.put(5, "Mate");
		tmap.put(6, "Seems");
		tmap.put(6, "Fine"); 
		for(Entry <Integer,String> e:tmap.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
		System.out.println(tmap.keySet()+""+tmap.values()+tmap.get(1));
		
		System.out.println(tmap.replace(6, "Boss"));
		System.out.println(tmap.descendingKeySet());
		System.out.println("descending map"+tmap.descendingMap());
		System.out.println(tmap.ceilingEntry(5));
		System.out.println(tmap.firstEntry());
		System.out.println(tmap.firstKey());
		System.out.println(tmap.floorEntry(0));
		System.out.println(tmap.lastEntry());
		System.out.println(tmap.lastKey());
		System.out.println(tmap.pollFirstEntry());
		System.out.println(tmap.pollLastEntry());


	}

}
