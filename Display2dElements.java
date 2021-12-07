package com.dnapass.training.java.day5;

public class Display2dElements {

	public static void main(String[] args) {
		int[][] array= {
				{1,2,3},
				{4,5,6},
				{7,8,9}};
		for(int row=0;row<array.length;row++) //length of the row 3times
		{
			for(int col=0;col<array[row].length;col++) //3times,3times,3times
			{
				System.out.print(array[row][col]+ " ");
			}
		}
		
			
	}

}
