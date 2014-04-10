package Classes;

import rpg.Character;

public class Wizzard extends Character
{
	public Wizzard(String name, int health, String weapon)
	{
		super(name, health, weapon);
	}
	
	@Override
	public void attaquer(rpg.Character enemy) {
		int newLife = (enemy.getHealth()-25);
		if (newLife < 0) {
			enemy.setHealth(0);
		}
		else {
			enemy.setHealth(newLife);
		}
		
	}
}
