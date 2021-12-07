package com.dnapass.training.java.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BufferedReaderClass {
    public static void main(String[] args)
        throws IOException
    {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        System.out.println("Enter Name:");
 
        // Reading data using readLine
        String str = reader.readLine();
        
 
        // Printing the read line
        System.out.println(str+" Hello HCL!");
    }
}