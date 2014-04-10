package Items;

import java.util.ArrayList;

public class shop {
private int potionsToSell;
private int numbersOfWeaponToSell;
ArrayList<String> weaponToSell2 = new ArrayList<String>();
String[] allWeapons = {"bow", "sword", "axe", "staff", "expert bow", "iron sword", "big axe", "big staff"};


	public shop(int potionToSell, int weaponToSell) {
		this.potionsToSell = potionToSell;
		this.numbersOfWeaponToSell = weaponToSell;
	}

	public ArrayList<String> getWeaponToSell2() {
		return weaponToSell2;
	}

	public int getPotionsToSell() {
		return potionsToSell;
	}

	public int getWeaponToSell() {
		return numbersOfWeaponToSell;
	}

	public void setPotionsToSell(int potionsToSell) {
		this.potionsToSell = potionsToSell;
	}

	public void setWeaponToSell(int weaponToSell) {
		this.numbersOfWeaponToSell = weaponToSell;
	}
	
	public void addNewWeaponToSell(int numbersOfWeaponToSell) {
		int compteur = this.numbersOfWeaponToSell;
		while (compteur > 0) {					
			int min = 1;
			int max = 9;
			int rand = (int) (Math.random() * (max - min) + min);
			this.weaponToSell2.add(allWeapons[rand-1]);
			compteur --;
		}
	}
}
