package com.java.intvw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LargeFileReader {

	public static void main(String[] args) {
		String filePath = "C:\\Brillio\\workspaces\\large.txt";

		byUsingStream(filePath);

//		byUsingBufferedReader(filePath);
	}

	private static void byUsingBufferedReader(String filePath) {
		Long start = System.currentTimeMillis();
		BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            
            while ((line = reader.readLine()) != null) {
            	System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total time taken for Buffered Reader: "+(System.currentTimeMillis() - start));
		
	}

	private static void byUsingStream(String filePath) {
		Long start = System.currentTimeMillis();
		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
			stream.forEach(line -> {
				System.out.println(line);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Total time taken for stream: "+(System.currentTimeMillis() - start));
	}

}
