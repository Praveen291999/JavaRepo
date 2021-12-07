package com.dnapass.training.java.day7;

//import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class File {
	static void FileWrite() {

		try {
			FileWriter myWriter = new FileWriter("filename.txt");

			myWriter.write("hi this is apple");
			myWriter.close();
			System.out.println("created");
		} catch (IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		FileWrite();

	}
}
