package Weapons;

public class Staff extends Weapon
{
	private int power;
	public Staff(int price, int damage, int range, int lvlRequired, int power)
	{
		super(price, damage, range, lvlRequired);
		this.power = power;
	}
	
	public int getPower() {
		return power;
	}
	
}