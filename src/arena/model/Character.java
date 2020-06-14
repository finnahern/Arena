package arena.model;

public class Character{
	
	private int id;
	private String name;
	private int hp;
	private int dmg;
	private int mod;
	private int ac;

	//ID Getter/Setter
	public int getID(){
		
		return id;
	}

	public void setID(int id){
		
		this.id = id;
	}

	//Name Getter/Setter
	public String getName(){
		
		return name;
	}

	public void setName(String name){
		
		this.name = name;
	}
	
	//HP Getter/Setter
	public int getHP(){
		
		return hp;
	}
	
	public void setHP(int hp){
		
		this.hp = hp;
	}	
	
	//DMG Getter/Setter
	public int getDMG(){
	
		return dmg;
	}
	
	public void setDMG(int dmg){
		
		this.dmg = dmg;
	}
	
	//Attack mod Getter/Setter
	public int getMod(){
		
		return mod;
	}
	
	public void setMod(int mod){
		
		this.mod = mod;
	}
	
	//AC Getter/Setter
	public int getAC(){
		
		return ac;
	}
	
	public void setAC(int ac){
		
		this.ac = ac;
	}
}	