package com.dnapass.training.java.day5;

public class DisplayElementsForEach {

	public static void main(String[] args) {
		int array[][]= {{1,2,3},
				{4,5,6},
				{7,8,9}};
		for(int[] row:array)  //iterates all rows
		{
			for(int val:row)  //iterates through all columns of current row
			{
				System.out.print(val +" ");
			}
		}
			

	}

}
