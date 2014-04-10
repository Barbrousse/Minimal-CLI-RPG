package Weapons;

public class Sword extends Weapon
{
	private int rarity;
	public Sword(int price, int damage, int range, int lvlRequired, int rarity)
	{
		super(price, damage, range, lvlRequired);
		this.rarity = rarity;
		
	}
	
	public int getRarity() {
		return rarity;
	}
	
}