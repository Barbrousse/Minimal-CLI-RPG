package Monster;

public class Goblin extends Monster{

	public Goblin(String name, int health, String weapon, int xpDropped, int goldDropped, int potionDropped, String itemsDropped) {
		super(name, health, weapon, xpDropped, goldDropped, potionDropped, itemsDropped);
	}
	
	@Override
	public void attaquer(rpg.Character perso) {
		int newLife = (perso.getHealth()-100);
		if (newLife < 0) {
			perso.setHealth(0);
		}
		else {
			perso.setHealth(newLife);
		}
	}
}
