package Weapons;

import Items.Items;

public abstract class Weapon extends Items {
	private int damage;
	private int range;
	private int lvlRequired;

	public Weapon(int price, int damage, int range, int lvlRequired)
	{
		super(price);
		this.damage= damage;
		this.range=range;
		this.lvlRequired=lvlRequired;
	}

	public int getDamage() {
		return damage;
	}

	public int getRange() {
		return range;
	}

	public int getLvlRequired() {
		return lvlRequired;
	}
	
}
