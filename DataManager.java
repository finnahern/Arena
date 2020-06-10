import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class DataManager{
	
	public ArrayList<String> readData(String fileName){
		
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
}