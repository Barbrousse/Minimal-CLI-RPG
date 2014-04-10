package Monster;

import rpg.Character;

public abstract class Monster extends Character{
	// Attributs
	private int xpDropped;
	private int goldDropped;
	private int potionDropped;
	private String itemsDropped;

	public Monster(String name, int health, String weapon, int xpDropped, int goldDropped, int potionDropped, String itemsDropped)
	{
		super(name, health, weapon);
		this.goldDropped = goldDropped;
		this.itemsDropped = itemsDropped;
		this.xpDropped = xpDropped;
		this.potionDropped = potionDropped;
	}

	public int getXpDropped() {
		return xpDropped;
	}

	public int getPotionDropped() {
		return potionDropped;
	}

	public int getGoldDropped() {
		return goldDropped;
	}

	public String getItemsDropped() {
		return itemsDropped;
	}
	
}
