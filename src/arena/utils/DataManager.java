package arena.utils;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter; 
import java.io.BufferedWriter;

public class DataManager{
	
	public static ArrayList<String> readData(String fileName){
		
		ArrayList<String> characterData = new ArrayList<String>();
	
		try{
		
			File data = new File(fileName);
			Scanner scanner = new Scanner(data);
			
			while(scanner.hasNextLine()){
			
				String nextLine	= scanner.nextLine();
				characterData.add(nextLine);
			}
			scanner.close();
		
		} catch (FileNotFoundException e){
		
			System.out.println("An error occured.");
			e.printStackTrace();
		}	
		
		return characterData;
	}
	
	public static void writeData(String result){
		
        try {
			
			String fileName = "output.txt";
			
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
            bufferedWriter.write(result);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
			
        } catch (IOException e) {
            
			System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}