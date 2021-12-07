package com.dnapass.training.java.files;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

public class JavaNIOFileDemo {

	public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub
		Path path = Paths.get("C:\\Users\\r-praveenkumar\\Sample.txt");
		System.out.format("toString: %s%n", path.toString());
		System.out.format("getFileName: %s%n", path.getFileName());
		System.out.format("getName(0): %s%n", path.getName(0));
		System.out.format("getNameCount: %s%n", path.getNameCount());
		System.out.format("subpath(0,2): %s%n", path.subpath(0, 2));
		System.out.format("get Parent: %s%n", path.getParent());
		System.out.format("getRoot: %s%n", path.getRoot());
		Path p1 = Paths.get("C:\\Users\\r-praveenkumar\\Sample.txt");
//Result is file:///home/logfile
		System.out.format("toString: %s%n", p1.toUri());
		Path path1 = Paths.get("sally\\bar");
		Path fullpath = path1.toAbsolutePath();
		Path fp = path1.toRealPath();
//Microsoft windows
		Path p11 = Paths.get("C:\\Users\\r-praveenkumar\\Sample.txt");
		System.out.format("%s%n", p11.resolve("bar"));
		Path pa2 = Paths.get("sally");
		Path pa1 = Paths.get("jce");
		Path pa1_to_pa2 = pa1.relativize(pa2);
		Path pa2_to_pa1 = pa2.relativize(pa1);
		Path pb1 = Paths.get("home");
		Path pb3 = Paths.get("home/sally/bar");
		Path p1_to_p3 = pb1.relativize(pb3);
		Path p3_to_p1 = pb3.relativize(pb1);
		Path path11 = null;
		Path otherPath = null;
		Path beginning = Paths.get("/home");
		Path ending = Paths.get("foo");
		if (path11.equals(otherPath)) {
//equality logic here
		} else if (path11.startsWith(otherPath)) {
//path begins with "/home"
		} else if (path11.endsWith(otherPath)) {
//path ends with "foo"
		}
		System.out.println();
		path = Paths.get("input.txt");
		System.out.println(Files.exists(path));
		Path tempFile = Files.createTempFile("dir", "inpt.txt");
		System.out.println(Files.exists(tempFile));
		Path tempDirectory = Files.createTempDirectory("dir-exists");
		System.out.println(Files.exists(tempDirectory));
		System.out.println(Files.notExists(tempDirectory));
		System.out.println(Files.isDirectory(tempDirectory));
		System.out.println(Files.isDirectory(tempFile));
		System.out.println(Files.isRegularFile(tempFile));
		System.out.println(Files.isReadable(tempFile));
		System.out.println(Files.isReadable(Paths.get("/root/not-readbale.txt")));
		boolean isRegularExecutableFile = Files.isRegularFile(path) & Files.isReadable(path) & Files.isExecutable(path);
		if (Files.isSameFile(p1, path)) {
//logic when the paths locate the same file
		}
		try {
			Files.delete(path);
		} catch (NoSuchFileException x) {
			System.err.format("%s: no such" + "file or directory %n", path);
		} catch (DirectoryNotEmptyException x) {
			System.err.format("%s not empty%n", path);
		} catch (IOException x) {
//File permission problems are caught here
			System.err.println(x);
		}
		Path source = p1;
		Path target = path;
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
		Path file = p1;
		BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
		System.out.println("CreationTime:" + attr.creationTime());
		System.out.println("lastAccessTime:" + attr.lastAccessTime());
		System.out.println("lastModifiedTime:" + attr.lastModifiedTime());

		System.out.println("isdirectory:" + attr.isDirectory());
		System.out.println("isOther:" + attr.isOther());
		System.out.println("isRegularFile:" + attr.isRegularFile());
		System.out.println("isSymbolicLink:" + attr.isSymbolicLink());
		System.out.println("size:" + attr.size());
		FileStore store = Files.getFileStore(file);
		long total = store.getTotalSpace();
		long used = (store.getTotalSpace() - store.getUsableSpace());
		long avail = store.getUsableSpace();
//Reading all bytes from a file
		byte[] fileArray;
		fileArray = Files.readAllBytes(file);
		Files.write(file, fileArray);
//Buffered I/O mehods for text files
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
		charset = Charset.forName("US-ASCII");
		String s = "file content";
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
			writer.write(s, 0, s.length());
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}

//Methods for Unbuffered Streams
		Path p = Paths.get("logfile.txt");
		try (InputStream in = Files.newInputStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				OutputStream out = new BufferedOutputStream(
						Files.newOutputStream(p, StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				out.write(line.getBytes(), 0, line.length());
			}
		} catch (IOException x) {
			System.err.println(x);
		}

	}

}
