import java.util.ArrayList;

public class Parser{

	public ArrayList<Character> init(ArrayList<String> characterData){

		ArrayList<Character> characters = new ArrayList<Character>();
		
		for(String line: characterData){
		
			Character character = parse(line);
			characters.add(character);
		}		
		
		return characters;
	}
	
	private Character parse(String line){
		
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