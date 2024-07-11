package com.concept.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BISnBOSFileRead {

	public static void main(String[] args) {
//		bisRead();
		bisMethods();

		writeFileBOS();
//		writeFileFOS();

	}

	private static void writeFileFOS() {
		try {
			FileOutputStream fos = new FileOutputStream("File2.txt", true );
			String s ="First line to write.";
			fos.write(s.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeFileBOS() {
		try {
			FileOutputStream fos = new FileOutputStream("File2.txt", true);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			String s  = "Hello";
			bos.write(s.getBytes());
			bos.close();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void bisMethods() {
		try {
			FileInputStream fin = new FileInputStream("file1.txt");
			BufferedInputStream bin = new BufferedInputStream(fin);

			// illustrating available method
			System.out.println("Number of remaining bytes:" + bin.available());

			// illustrating markSupported() and mark() method
			boolean b = bin.markSupported();
			if (b)
				bin.mark(bin.available());

			// illustrating skip method
			/*
			 * Original File content: This is my first line This is my second line
			 */
			bin.skip(4);
			System.out.println("FileContents :");

			// read characters from FileInputStream and
			// write them
			int ch;
			while ((ch = bin.read()) != -1)
				System.out.print((char) ch);

			System.out.println("doing reset..");
			// illustrating reset() method
			bin.reset();
			while ((ch = bin.read()) != -1)
				System.out.print((char) ch);

			// close the file
			fin.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void bisRead() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("File1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedInputStream bis = new BufferedInputStream(fis);
		int ch;
		try {
			while ((ch = bis.read()) != -1) {
				System.out.print((char) ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
