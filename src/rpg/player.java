package rpg;

public class player {

private int gold;
private int potions;
private int experience;
private int level;

	public player(int gold, int potions, int experience, int level){
		this.gold = gold;
		this.potions = potions;
		this.experience = experience;
		this.level = level;
	}

	public int getGold() {
		return gold;
	}

	public int getPotions() {
		return potions;
	}

	public int getExperience() {
		return experience;
	}

	public void setPotions(int potions) {
		this.potions = potions;
	}

	public int getLevel() {
		return level;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
}
