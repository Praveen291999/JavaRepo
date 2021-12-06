package com.dnapass.training.java.Collections;
import java.util.*;
import java.util.Map.Entry;
public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> hmap= new HashMap<Integer,String>();
		hmap.put(0,"Java");
		hmap.put(1, "is ");
		hmap.put(2, "a");
		hmap.put(3, "Programming");
		hmap.put(4, "Language");
		hmap.put(5, "!");
		hmap.put(6, "!");
		hmap.put(6, "Good"); //overrides the previous value
		
		for(Entry <Integer,String> e:hmap.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
		
		HashMap<Integer,String> hmap1=new HashMap<Integer,String>(hmap);
		hmap1.put(7, "boss");
		System.out.println(hmap1);
		
		HashMap<Integer,String> hmap2=new HashMap<Integer,String>();
		hmap2.putAll(hmap1);
		hmap2.put(8, "Good Morning");
		System.out.println(hmap2);
		
		HashMap<Integer,String> hmap3=new HashMap<Integer,String>(hmap);
		hmap3=(HashMap<Integer,String>)hmap2.clone();
		System.out.println(hmap3);
		
		System.out.println("Conrains key : " + hmap2.containsKey(7)+hmap2.containsValue("seems"));
		System.out.println(hmap2.entrySet()+hmap2.get(0));
		
		//generic set
		Set s=hmap.entrySet();
		System.out.println("Set :"+s);
	}

}
