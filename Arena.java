import java.util.ArrayList;
import java.util.Scanner;

public class Arena{
	
	public void arena(){
		
		Parser parser = new Parser();
		DataManager dataManager = new DataManager();
		String fileName = "data.txt";
	
		ArrayList<String> characterData = dataManager.readData(fileName);
		ArrayList<Character> characters = parser.init(characterData);
		
		characterSelect(characters);
	}

	public void characterSelect(ArrayList<Character> characters){
		
		Character fighter1;
		Character fighter2;
		
		System.out.println("Fighters:");
		characters.forEach(character -> {
			System.out.println(character.getID() + " " + character.getName());
		});
		
		//Read Input method
		fighter1 = readInput(characters);
		fighter2 = readInput(characters);
		
		//Fight method
		fight(fighter1, fighter2);
	}	
	
	public Character readInput(ArrayList<Character> characters){
		
		Scanner scanner = new Scanner(System.in);
		Character selectedFighter;
		
		while(true){
			
			System.out.println("Choose a fighter:");
			String input = scanner.nextLine();
			
			try{
		
				int fighterID = Integer.parseInt(input);
				selectedFighter = characters.get(fighterID);
			
			} catch (NumberFormatException e){
			
				System.out.println("Input must be a number.");
				continue;
		
			} catch (IndexOutOfBoundsException e){
			
				System.out.println("Input must be between 0 and " + (characters.size() - 1));
				continue;
			}

			break;
		}
		
		return selectedFighter;
	}	
	
	public void fight(Character fighter1, Character fighter2){
		
		//Fighter 1
		String name1 = fighter1.getName();
		int hp1 = fighter1.getHP();
		int dmg1 = fighter1.getDMG();
		
		//Fighter 2
		String name2 = fighter2.getName();
		int hp2 = fighter2.getHP();
		int dmg2 = fighter2.getDMG();
		
		while(hp2 > 0 && hp1 > 0){
			
			hp2 = hp2 - dmg1;
			System.out.println(name1 + " deals " + dmg1 + " damage. " + name2 + "'s HP is " + hp2);
			
			if(hp2 <= 0){
				
				System.out.println(name2 + " is defeated! " + name1 + " wins!");
				break;
			}	
			
			hp1 = hp1 - dmg2;
			System.out.println(name2 + " deals " + dmg2 + " damage. " + name1 + "'s HP is " + hp1);
			
			if(hp1 <= 0){
				
				System.out.println(name1 + " is defeated! " + name2 + " wins!");
				break;
			}	
		}
	}	
}