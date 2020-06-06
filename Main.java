import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
	
	public static void main (String []args){
		
		ArrayList<String> characterData = new ArrayList<String>();
	
		try{
			
			File data = new File("data.txt");
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
		
		for(String line: characterData){
		
			Character character = parse(line);
			
			System.out.println(character.getID());
			System.out.println(character.getName());
			System.out.println(character.getHP());
			System.out.println(character.getDMG());
		}
	}
	
	public static Character parse(String line){
		
		Character character = new Character();
		
		String[] dataArray = new String[4];
		int subZero = 0;
		int arrayCounter = 0;
		
		for(int i = 0; i < line.length(); i++){
			
			char x = line.charAt(i);
			if(x == ','){
				
				dataArray[arrayCounter] = line.substring(subZero, i);
				
				subZero = i + 1;
				arrayCounter++;
				
			} else if (i == line.length() - 1){
				
				dataArray[arrayCounter] = line.substring(subZero);
			}	
		}
		
		character.setID(Integer.parseInt(dataArray[0]));
		character.setName(dataArray[1]);
		character.setHP(Integer.parseInt(dataArray[2]));
		character.setDMG(Integer.parseInt(dataArray[3]));
		
		return character;
	}
}