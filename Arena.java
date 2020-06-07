import java.util.ArrayList;

public class Arena{
	
	public void arena(){
		
		Parser parser = new Parser();
		DataManager dataManager = new DataManager();
		String fileName = "data.txt";
	
		ArrayList<String> characterData = dataManager.readData(fileName);
		ArrayList<Character> characters = parser.init(characterData);
		
		System.out.println(characters.get(0).getName());
		System.out.println(characters.get(1).getName());
		System.out.println(characters.get(2).getName());
		System.out.println(characters.get(3).getName());
		System.out.println(characters.get(4).getName());
	}	
}