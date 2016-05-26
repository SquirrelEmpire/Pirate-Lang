package com.arrgh.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import com.arrgh.main.tokenizer.Token;
import com.arrgh.main.tokenizer.Tokenizer;

public class PirateUtility {
	
	public static String readFile(String path) {
		
		String fileText = "";
		
		try {
			
			File file = new File(path);
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				
			String line;
				
			while((line = bufferedReader.readLine()) != null){
					
				fileText += line + "\n";
			}
			
			bufferedReader.close();
		
		} catch(FileNotFoundException e) {
			
			e.printStackTrace();
		
		} catch(IOException e) {
			
			e.printStackTrace();
		}
		
		return fileText;
	}
	
	public static LinkedList<LinkedList<String>> splitTokens(Tokenizer tokenizer, String text) {
		
		LinkedList<LinkedList<String>> tokens = new LinkedList<LinkedList<String>>();
		
		for(String line : text.split("\n")) {
			
			try {
				
				LinkedList<String> tempLine = new LinkedList<String>();
				
				tokenizer.tokenize(line);

				for (Token tok : tokenizer.getTokens()) {
					
					tempLine.add(tok.getSequence());
				}
				
				tokens.add(tempLine);
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
		}
		
		return tokens;
	}
}