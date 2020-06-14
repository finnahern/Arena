package arena;

import java.util.ArrayList;
import java.util.Scanner;
import arena.model.Character;
import arena.utils.*;

public class Arena{
	
	//DataManager dataManager = new DataManager();
	
	public void arena(){
		
		Parser parser = new Parser();
		String fileName = "data.txt";
	
		ArrayList<String> characterData = DataManager.readData(fileName);
		ArrayList<Character> characters = parser.init(characterData);
		
		characterSelect(characters);
	}

	//Prints out character info, initialise method to read user input and starts the fight
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
	
	//Reads user input and selects character to fight
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
	
	//d20 method for attack rolls
	public int roll(){
		
		int result = ((int)(Math.random() * 20) + 1);
		
		return result;
	}	
	
	public void fight(Character fighter1, Character fighter2){
		
		//Fighter 1
		String name1 = fighter1.getName();
		int hp1 = fighter1.getHP();
		int dmg1 = fighter1.getDMG();
		int mod1 = fighter1.getMod();
		int ac1 = fighter1.getAC();
		
		//Fighter 2
		String name2 = fighter2.getName();
		int hp2 = fighter2.getHP();
		int dmg2 = fighter2.getDMG();
		int mod2 = fighter2.getMod();
		int ac2 = fighter2.getAC();
		
		//Combat Loop
		while(hp2 > 0 && hp1 > 0){
			
			//Fighter 1 attack
			
			int roll1 = roll() + mod1;
			
			if(roll1 >= ac2){
			
				hp2 = hp2 - dmg1;
				System.out.println(name1 + " rolled " + roll1 + ". It hits!");
				System.out.println(name1 + " deals " + dmg1 + " damage. " + name2 + "'s HP is " + hp2);
				System.out.println("");
			
			}else{
			
				System.out.println(name1 + " rolled a " + roll1 + ". It missed!");
				System.out.println("");
			}
			
			if(hp2 <= 0){
				
				String result = name2 + " is defeated! " + name1 + " wins!";
				System.out.println(result);
				DataManager.writeData(result);
				break;
			}	
			
			//Fighter 2 attack
			
			int roll2 = roll() + mod2;
			
			if(roll2 >= ac1){
				
				hp1 = hp1 - dmg2;
				System.out.println(name2 + " rolled " + roll2 + ". It hits!");
				System.out.println(name2 + " deals " + dmg2 + " damage. " + name1 + "'s HP is " + hp1);
				System.out.println("");
				
			}else{
				
				System.out.println(name2 + " rolled a " + roll2 + ". It missed!");
				System.out.println("");
			}
			
			if(hp1 <= 0){
				
				String result = name1 + " is defeated! " + name2 + " wins!";
				System.out.println(result);
				DataManager.writeData(result);
				break;
			}	
		}
		rerun();
	}	
	
	public void rerun(){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like to run another fight? Y/N");
		String input = scanner.nextLine();
		
		if(input.equals("Y") || input.equals("y")){
			
			arena();
		
		} else if(input.equals("N") || input.equals("n")){
			
			System.exit(0);
		
		}else{
			
			System.out.println("Input must be Y or N.");
			rerun();
		}
	}
}