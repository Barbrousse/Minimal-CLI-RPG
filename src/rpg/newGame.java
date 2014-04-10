package rpg;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import rpg.Character;
import Classes.Ranger;
import Classes.Warrior;
import Classes.Wizzard;
import Items.potion;
import Items.shop;
import Monster.Dragon;
import Monster.Goblin;
import Monster.Golem;
import Monster.Monster;
import Monster.Rat;
public class newGame {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		player hero = newPlayer();
		Scanner sc = new Scanner(System.in);
		System.out.println("Hi new hero, what's your name ?");
		String name = sc.nextLine();
		System.out.println("Choose your classe");
		System.out.println("Type 1 to be a Ranger");
		System.out.println("Type 2 to be a Warrior");
		System.out.println("Type 3 to be a Wizzard");
		int classe = sc.nextInt();
		potion smallPotion;
		Character perso;
		Character adversaire = null;
		shop Shop;
		if (classe == 1) {
			System.out.println("So you're a Ranger named "+name+" your name sucks but whatever... Let's go "+name+" (seriously i hate your name)");
			perso = new Ranger(name, 100, "bow");
		}
		else if (classe == 2) {
			System.out.println("So you're a Warrior named "+name+" let's go dude.");
			perso = new Warrior(name, 200, "sword");
		}
		else {
			System.out.println("So you're a Wizzard named "+name+"... Seriously you've choose wizzard ? Everybody know that wizzards sucks... Whatever it's too late now, let's go");
			perso = new Wizzard(name, 75, "staff");
		}
		String space = "--------------------------------------------------------------------------------------";
		
		
		int action;
		while (perso.getHealth() > 0 ) {
			action =-1;
			System.out.println("What do you want to do ?");
			System.out.println("(1)Show inventory | (2)Show experience & lvl | (3)Show live | (4)Move to the next room");
			try {
				action = sc.nextInt(); 
				switch (action) {
				case 1:
					System.out.println("Your weapons : "+ perso.getWeapon());
					System.out.println("Your gorld(s) : " + hero.getGold());
					System.out.println("Your potion(s) : " + hero.getPotions());
					int drinkPotion =-1;
					if (hero.getPotions() > 0) {
						System.out.println("Drink a potion ? (1)Yes| (2)No");
						drinkPotion = sc.nextInt();
						if (drinkPotion == 1){
							smallPotion = new potion(50);
							perso.drinkPotion(smallPotion.getHealthRestored());
							hero.setPotions(hero.getPotions()-1);
						}
						else {
							drinkPotion = -1;
						}
					}
					break;
				case 2:
					System.out.println("Your experience : " + hero.getExperience());
					System.out.println("Your level : " + hero.getLevel());
					break;
				case 3:
					System.out.println("Your life : " + perso.getHealth());
					break;
				case 4:
					int min = 1;
					int max = 5;
					int rand = (int) (Math.random() * (max - min) + min);
					if (rand == 1){
						if (hero.getLevel() < 5)
							Shop = new shop (1, 1); 
						else if (hero.getLevel() < 10)
							Shop = new shop (1,1);
						else if (hero.getLevel() < 15)
							Shop = new shop (2,1);
						else 
							Shop = new shop(2,2);
						int buySomething = 0;
						System.out.println("--- Welcome to the SHOP ! ---");
						while (buySomething != 6) {
							System.out.println("You can buy :");
							System.out.println("Number of potion to sell : "+ Shop.getPotionsToSell() + " Price : 50po");
							System.out.println("Number of weapon to sell : "+ Shop.getWeaponToSell() + " Price : 200po");
							System.out.println("You can sell :");
							System.out.println("Number of potion that you can sell : "+ hero.getPotions() + "| Price : 25po");
							System.out.println("Weapon that you can sell : "+ perso.getWeapon() + "| Price : 100po");
							System.out.println("(1) buy potion(s) | (2) buy weapon(s) | (3) sell potion | (4) sell weapon | (6) quit shop");
							buySomething = sc.nextInt();
							if (buySomething == 1) {
								//buy potion
								if (hero.getGold() >= 50) {
									hero.setGold(hero.getGold() - 50);
									hero.setPotions(hero.getPotions()+1);
									Shop.setPotionsToSell(Shop.getPotionsToSell() - 1);
								}
								else {System.out.println("You haven't enought gold");}
							}
							else if (buySomething == 2) {
								//buy weapon
								if (hero.getGold() >= 200){
									Shop.addNewWeaponToSell(Shop.getWeaponToSell());
									hero.setGold(hero.getGold()-200);
									Shop.setWeaponToSell(Shop.getWeaponToSell()-1);
									int compteur = 1;
									int buyWeapon;
									
									for (String weapon : Shop.getWeaponToSell2()) {
										System.out.println("if you want to buy "+weapon+" type "+compteur);
										compteur ++;
									}
									System.out.println("if you want to return to the store type 0");
									buyWeapon = sc.nextInt();
									if (buyWeapon > 0 && buyWeapon <= 9){
										ArrayList<String> newWeapon = Shop.getWeaponToSell2();
										perso.setWeapon(1, newWeapon.get(buyWeapon-1));
									}
									else if(buyWeapon == 0){
										break;
									}
								}
								else { System.out.println("You haven't enought gold");}
							}
							else if (buySomething == 3) {
								//sell potion
								if (hero.getPotions() >= 1){
									hero.setPotions(hero.getPotions()-1);
									hero.setGold(hero.getGold()+25);
									Shop.setPotionsToSell(Shop.getPotionsToSell()+1);
								}
							}
							else if (buySomething == 4){
								//sell weapon
								int compteur = 1;
								int sellWeapon;
								for (String weapon : perso.getWeapon()) {
									System.out.println("if you want to buy "+weapon+" type "+compteur);
									compteur ++;
								}
								System.out.println("if you want to return to the store type 0");
								sellWeapon = sc.nextInt();
								if (sellWeapon > 0 && sellWeapon <= 9){
									ArrayList<String> newWeapon = perso.getWeapon();
									perso.setWeapon(2, newWeapon.get(sellWeapon-1));
									hero.setGold(hero.getGold()+100);
								}
								else if(sellWeapon == 0){
									break;
								}
							}
							else if (buySomething == 6){
								//leave the shop
								break;
							}
						}
					}
					else {
						if (rand == 2 && hero.getLevel() > 5){
							adversaire = new Goblin("Goblin", 300, "axe", 200, 200, 2, "axe");
						}
					
						else if (rand == 3 && hero.getLevel() > 10){
							adversaire = new Golem("Golem", 800, "sword", 600, 2000, 3, "sword");
						}
						else if (rand == 4 && hero.getLevel() > 20){
							adversaire = new Dragon("Dragon", 2000, "fire", 2000, 5000, 4, "sword in fire");
						}
						else {
							adversaire = new Rat("rat", 100, "teeths", 40, 1, 1, "");
						}
						System.out.println("Here's a "+adversaire.getName()+" with "+adversaire.getHealth()+" hp, he want to attack you with his "+adversaire.getWeapon());
						System.out.println("What do you want to do ? (1) attack this monster | (2) run");
						int actionVersusAdversaire = sc.nextInt();
						if (actionVersusAdversaire == 1){
							while (adversaire.getHealth() > 0 && perso.getHealth() > 0){
								if (perso.getHealth() > 0){
									System.out.println("you attack the enemy");
									perso.attaquer(adversaire);
									System.out.println("Enemy's life :");
									System.out.println(adversaire.getHealth()+" pv");
									System.out.println(space);
								}
								if (adversaire.getHealth() > 0) {
									System.out.println("The enemy attack you");
									adversaire.attaquer(perso);
									System.out.println("Your life :");
									System.out.println(perso.getHealth()+" pv");
									System.out.println(space);
								}
								if (adversaire.getHealth() == 0){
									System.out.println("You killed the enemy");
									System.out.println("He drop "+((Monster) adversaire).getPotionDropped()+" potion(s)");
									hero.setPotions(hero.getPotions() +((Monster) adversaire).getPotionDropped());
									hero.setExperience(hero.getExperience()+((Monster) adversaire).getXpDropped());
									//perso.setWeapon(1, adversaire.getWeapon(1));
									if (hero.getExperience() >= 300){
										while (hero.getExperience() >= 300) {
											hero.setLevel(hero.getLevel()+1);
											hero.setExperience(hero.getExperience()-300);
											perso.setHealthMax(perso.getHealthMax()+150);
											perso.setHealth(perso.getHealthMax());
											System.out.println("You gained a level");
											System.out.println("You're now level "+hero.getLevel()+" and "+hero.getExperience()+" xp");
											System.out.println("Your health max is now "+perso.getHealthMax()+" pv");
										}
									}
									else {
										System.out.println("You won "+((Monster) adversaire).getXpDropped()+" xp.");
									}
								}
								else if (perso.getHealth() == 0){
									System.out.println("you're dead dude");
								}
							}
						}
						else if (actionVersusAdversaire == 2){break;}
						break;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Option non disponible");
				sc.nextLine();
			}
			System.out.println(space);
		}
	}
	
	public static player newPlayer() {
		player p = new player(0,0,0,1); //gold,potion,experience,level
		return p;
	}
	

}
