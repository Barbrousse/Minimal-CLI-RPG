package Monster;

public class Rat extends Monster{

	public Rat(String name, int health, String weapon, int xpDropped, int goldDropped, int potionDropped, String itemsDropped) {
		super(name, health, weapon, xpDropped, goldDropped, potionDropped, itemsDropped);
	}
	
	@Override
	public void attaquer(rpg.Character hero) {
		int newLife = (hero.getHealth()-25);
		if (newLife < 0) {
			hero.setHealth(0);
		}
		else {
			hero.setHealth(newLife);
		}
		
	}
}
