package com.dnapass.training.java.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.dnapass.training.java.day9.account.Account;


public class JavaIOFileDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("input.txt");
			out = new FileOutputStream("output-bytes.txt");
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			FileReader inputStream = new FileReader("input.txt");
			FileWriter outputStream = new FileWriter("output.chars.txt");
			while ((c = inputStream.read()) != -1) {
				outputStream.write(c);
			}
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			PrintWriter writer = new PrintWriter(new FileWriter("buffered-output.txt"));

			String l;
			while ((l = reader.readLine()) != null) {
				writer.println(l);
			}

			BufferedReader bufReader = new BufferedReader(new FileReader("input.txt"), 16384);
			BufferedWriter bufWriter = new BufferedWriter(new FileWriter("buffer.output.txt"), 16834);

			while ((c = bufReader.read()) != -1) {
				bufWriter.write(c);
			}
			while ((l = bufReader.readLine()) != null) {
				bufWriter.write(l);
			}
			Scanner s = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));

			while (s.hasNext()) {
				System.out.println(s.next());
			}

			double sum = 0;
			s = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
			s.useLocale(Locale.US);

			while (s.hasNext()) {
				if (s.hasNextDouble()) {
					sum += s.nextDouble();
				} else {
					s.next();
				}
			}

			final String dataFile = "invoice.dat";
			final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
			final int[] units = { 12, 8, 13, 29, 50 };
			final String[] descs = { "Java T-shirt", "Java Mug", "Duke Juggling Dolls", "Java Pin", "Java Key Chain" };
			// List<Invoice> invoices=DataLoader.newInvoices();

			DataOutputStream out1 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));

			for (int i = 0; i < prices.length; i++) {
				out1.writeDouble(prices[i]);
				out1.writeInt(units[i]);
				out1.writeUTF(descs[i]);

			}
			DataInputStream in1 = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
			double price;
			int unit;
			String desc;
			double total = 0.0;

			try {
				while (true) {
					price = in1.readDouble();
					unit = in1.readInt();
					desc = in1.readUTF();
					System.out.format("you ordered %d" + "units of %s at $%.2f%n", units, desc, price);
					total += unit * price;
				}
			} catch (EOFException e) {
			}
			Account account = new Account(1, 20000);
			ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("bank.dat"));
			out2.writeObject(account);

			ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("bank.dat"));
			Account account1 = (Account) in2.readObject();
			System.out.println(account1);

			List<Account> list1 = new ArrayList<Account>();
			list1.add(new Account(1, 20000));
			list1.add(new Account(2, 20000));
			list1.add(new Account(3, 20000));
			list1.add(new Account(4, 20000));
			out2.writeObject(list1);

			ArrayList<Account> list = (ArrayList<Account>) in2.readObject();
			System.out.println(list);
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}

	}
}
