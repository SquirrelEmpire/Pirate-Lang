package com.arrgh.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class PirateUtility {
	
	// Reads file from path, stores and returns as LinkedList<String>:
	public static LinkedList<String> readFile(String path) {
		
		LinkedList<String> lines = new LinkedList<String>();
		
		try {
			
			File file = new File(path);
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				
			String line;
				
			while((line = bufferedReader.readLine()) != null){
					
				lines.add(line);
			}
			
			bufferedReader.close();
		
		} catch(FileNotFoundException e) {
			
			e.printStackTrace();
		
		} catch(IOException e) {
			
			e.printStackTrace();
		}
		
		return lines;
	}
}