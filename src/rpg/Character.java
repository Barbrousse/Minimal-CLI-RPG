package rpg;

import java.util.ArrayList;

public abstract class Character {
	// Attributes
	private String name;
	private int health;
	private int healthMax;
	ArrayList<String> weapon = new ArrayList<String>();
	//private String weapon;
	// Constructor	
	public Character(String name, int health, String weapon)
	{
		this.name = name;
		this.health = health;
		this.healthMax = health;
		this.weapon.add(weapon);
	}
	
	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public ArrayList<String> getWeapon() {
		return weapon;
	}
	
	public void setWeapon(int action, String newWeapon) {
		if (action == 1){
			//add weapon
			this.weapon.add(newWeapon);
		}
		else if (action == 2){
			//remove weapon
			this.weapon.remove(newWeapon);			
		}
	}

	public abstract void attaquer(Character hero);

	
	public void drinkPotion(int healthRestored) {
		health += healthRestored;
		if (health > healthMax){
			health = healthMax;
		}
	}

	public int getHealthMax() {
		return healthMax;
	}

	public void setHealthMax(int healthMax) {
		this.healthMax = healthMax;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
