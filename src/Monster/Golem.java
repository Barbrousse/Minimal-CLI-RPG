package Monster;

public class Golem extends Monster{

	public Golem(String name, int health, String weapon, int xpDropped,	int goldDropped, int potionDropped, String itemsDropped) {
		super(name, health, weapon, xpDropped, goldDropped, potionDropped, itemsDropped);
	}
	
	@Override
	public void attaquer(rpg.Character perso) {
		int newLife = (perso.getHealth()-700);
		if (newLife < 0) {
			perso.setHealth(0);
		}
		else {
			perso.setHealth(newLife);
		}
	}
}
