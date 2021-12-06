package com.dnapass.training.java.Collections;

import java.util.HashMap;
import java.util.Map;

public class FrequencyUtil {
	public static void main(String[] args)
	{
		String[] words= {"is", "if", "is", "to", "it", "is", "java"};
		HashMap<String,Integer> m=new HashMap<String,Integer>();
		
		for(String a:words)
		{
			Integer freq=m.get(a);
			m.put(a,(freq==null)?1:freq+1);
			
		}
		System.out.println(m.size()+" distinct words:");
		System.out.println(m);
	}

}
