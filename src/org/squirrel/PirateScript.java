package org.squirrel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PirateScript {
	
	//Pirate-Script V0.0.1
	//Made by Dem_Squirre/DemSquirrel for Coding Pirates
	//https://codingpirates.dk/
	
	public static ArrayList<String> toks = new ArrayList<String>();
	public static ArrayList<String> lines = new ArrayList<String>();
	private static boolean strState = false;
	
	public static void main(String[] args) throws IOException{
		readFile("test/testprogram.pirates");

		tokenize(lines);
		
		parse(toks);
	}
	
	//Reading the file
	public static void readFile(String path) throws FileNotFoundException{
		try {
			File file = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null){
				lines.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}	
	public static ArrayList<String> tokenize (ArrayList<String> lines){		
		String tok = "";
		String code = "";
		boolean scanString = false;
		for (int i = 0; i < lines.size(); i++) {
			
			code = lines.get(i).replace(" ", "").replace("\n", "");
			for (int j = 0; j < code.length(); j++) {
				tok += code.charAt(j); //code.concat(Character.toString(code.charAt(j)));
				//System.out.println(tok);
				if(tok.equals("AHOY") && !scanString){
					//I FOYUND A PRINT :D
					
					toks.add("print");
					tok = "";
					
				}else if(tok.equals("\"")){
					scanString = true;
					String tempString = code.substring(code.indexOf("\""));
					//System.out.println(code.substring(code.indexOf("\"")));
					toks.add("STR:"+tempString);
					tok = "";
					scanString = false;
				}
			}
			//System.out.println(code);

		}
		
		System.out.println(toks);
		return null;
	}
	
	public static void parse(ArrayList<String> tokens){
		
		for(int i = 0; i < tokens.size(); i++){
			if(tokens.get(i).equals("print") && tokens.get(i+1).substring(0, 4).equals("STR:")){
				String string = tokens.get(i+1).substring(4).replace("\"", "");
				System.out.println(string);
			}
		}
	}
}