package Classes;

import rpg.Character;

public class Ranger extends Character
{
	public Ranger(String name, int health, String weapon)
	{
		super(name, health, weapon);
	}
	
	@Override
	public void attaquer(rpg.Character enemy) {
		int newLife = (enemy.getHealth()-50);
		if (newLife < 0) {
			enemy.setHealth(0);
		}
		else {
			enemy.setHealth(newLife);
		}
		
	}
}
